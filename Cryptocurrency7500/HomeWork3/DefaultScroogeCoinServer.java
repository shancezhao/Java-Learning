package hw3;

import java.security.KeyPair;
import java.security.PublicKey;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Scrooge creates coins by adding outputs to a transaction to his public key.
//In ScroogeCoin, Scrooge can create as many coins as he wants.
//No one else can create a coin.
//A user owns a coin if a coin is transfer to him from its current owner
public class DefaultScroogeCoinServer implements ScroogeCoinServer {

    private KeyPair scroogeKeyPair;
    private ArrayList<Transaction> ledger = new ArrayList();

    //Set scrooge's key pair
    @Override
    public synchronized void init(KeyPair scrooge) {
        scroogeKeyPair = new KeyPair(scrooge.getPublic(), scrooge.getPrivate());
    }

    //For every 10 minute epoch, this method is called with an unordered list of proposed transactions
    // 		submitted during this epoch.
    //This method goes through the list, checking each transaction for correctness, and accepts as
    // 		many transactions as it can in a "best-effort" manner, but it does not necessarily return
    // 		the maximum number possible.
    //If the method does not accept an valid transaction, the user must try to submit the transaction
    // 		again during the next epoch.
    //Returns a list of hash pointers to transactions accepted for this epoch
    public synchronized List<HashPointer> epochHandler(List<Transaction> txs) {
        List<HashPointer> list = new ArrayList<HashPointer>();
        while (!txs.isEmpty()) {
            List<Transaction> invalidtemp = new ArrayList<Transaction>();
            for (Transaction tx : txs) {
                //check if it is valid
                if (!isValid(tx)) {
                    invalidtemp.add(tx);
                } else {
                    //make a pointer to the transaction
                    ledger.add(tx);
                    HashPointer hp = new HashPointer(tx.getHash(), ledger.size() - 1);
                    list.add(hp);   //the accepted transactions
                }
            }
            if (txs.size() == invalidtemp.size()) {
                break;
            }
            txs = invalidtemp;
        }
        return list;
    }
    //Returns true if and only if transaction tx meets the following conditions:
    //CreateCoin transaction
    //	(1) no inputs
    //	(2) all outputs are given to Scrooge's public key
    //	(3) all of tx’s output values are positive
    //	(4) Scrooge's signature of the transaction is included

    //PayCoin transaction
    //	(1) all inputs claimed by tx are in the current unspent (i.e. in getUTOXs()),
    //	(2) the signatures on each input of tx are valid,
    //	(3) no UTXO is claimed multiple times by tx,
    //	(4) all of tx’s output values are positive, and
    //	(5) the sum of tx’s input values is equal to the sum of its output values;
    @Override
    public synchronized boolean isValid(Transaction tx) {
        Transaction tran = tx;
        switch (tran.getType()) {
            case Create:
                if (tran.numInputs() > 0) {
                    return false; //no inputs
                }
                for (Transaction.Output out : tran.getOutputs()) {
                    if (out.getPublicKey() != scroogeKeyPair.getPublic()) {
                        return false;  //all outputs should be Scrooge's pk
                    }
                    if (out.getValue() <= 0) {
                        return false; //outputs are positive
                    }
                }
                try {
                    Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
                    signature.initVerify(scroogeKeyPair.getPublic());
                    signature.update(tx.getRawBytes());
                    if (!signature.verify(tran.getSignature())) {
                        return false;   //Scrooge's signature of the transaction is included
                    }
                } catch (Exception ex) {
                    throw new RuntimeException();
                }
                return true;
            case Pay:
                Set<UTXO> utxo = getUTXOs();
                double inSum = 0;
                
                for (int i = 0; i < tran.numInputs(); i++) {
                    Transaction.Input in = tran.getInputs().get(i);
                    int outIndex = in.getIndexOfTxOutput();
                    int indexofLedger = -1;
                    for(int j=0;j<ledger.size();j++){
            			if(Arrays.equals(ledger.get(j).getHash(),in.getHashOfOutputTx())){
            				HashPointer iphp = new HashPointer(in.getHashOfOutputTx(), j);
            				UTXO inputxo = new UTXO(iphp,outIndex);
            				if(utxo.contains(inputxo)) {
            					indexofLedger=j;
            				}
            			}
            		}
					if(indexofLedger==-1) return false; //checking if two transactions have same hash

                    Transaction.Output inout = ledger.get(indexofLedger).getOutput(outIndex);
                    inSum += inout.getValue();
                    PublicKey publickey = inout.getPublicKey();
                    try {
                        Signature sign = Signature.getInstance(SIGNATURE_ALGORITHM);
                        sign.initVerify(publickey);
                        sign.update(tran.getRawDataToSign(i));
                        if (!sign.verify(in.getSignature())) {
                            return false;
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                //output
                double outSum = 0;
                for (Transaction.Output op : tran.getOutputs()) {
                    if (op.getValue() <= 0) {
                        return false;
                    }
                    outSum = op.getValue() + outSum;
                }
                if (Math.abs(inSum - outSum) < 0.000001) {
                    return true;
                } else {
                    return false;
                }
        }
        return false;
    }

    //Returns the complete set of currently unspent transaction outputs on the ledger
    @Override
    public synchronized Set<UTXO> getUTXOs() {
        try {
            Set<UTXO> utxo = new HashSet<UTXO>();
            for (int ledgerIndex = 0; ledgerIndex < ledger.size(); ledgerIndex++) {
                Transaction tran = ledger.get(ledgerIndex);
                switch (tran.getType()) {
                    case Create:
                        for (Transaction.Output out : tran.getOutputs()) {
                            HashPointer createHP = new HashPointer(tran.getHash(), ledgerIndex);
                            int index = tran.getIndex(out);
                            UTXO createUtxo = new UTXO(createHP, index);
                            utxo.add(createUtxo);
                        }
                        break;
                    case Pay:
                        for (int i = 0; i < tran.numInputs(); i++) {
                            Transaction.Input input = tran.getInputs().get(i);
                            int outIndex = input.getIndexOfTxOutput();

                            int indexofLedger = -1;
                            for (int k = 0; k < ledger.size(); k++) {
                                if (Arrays.equals(ledger.get(k).getHash(), input.getHashOfOutputTx())) {
                                    HashPointer inhp = new HashPointer(input.getHashOfOutputTx(), k);
                                    UTXO inUTXO = new UTXO(inhp, outIndex);
                                    if (utxo.contains(inUTXO)) {
                                        indexofLedger = k;
                                    }
                                }
                            }
                            HashPointer inHP = new HashPointer(input.getHashOfOutputTx(), indexofLedger);
                            UTXO inputUTXO = new UTXO(inHP, outIndex);
                            utxo.remove(inputUTXO);
                        }
                        for (Transaction.Output out : tran.getOutputs()) {
                            HashPointer hp = new HashPointer(tran.getHash(), ledgerIndex);
                            int j = tran.getIndex(out);
                            UTXO outUTXO = new UTXO(hp, j);
                            utxo.add(outUTXO);
                        }
                        break;
                }
            }
            return utxo;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
