package Homework2;

import java.io.File;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMDecryptorProvider;
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.pkcs.PKCSException;

import javax.xml.bind.DatatypeConverter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

public class GenerateDigitalSignature {

    /*
    Reads Scrooge's key pair from disk
    Generate Scrooge's digital signature for the message "Pay 3 bitcoins to Alice".
    Do not include the quotations in the message. Capitalization matters.
 In your submission, include your code and the digital signature in hexadecimal.
     */
    private static final String KEY_ALGORITHM = "ECDSA";
    private static final String SIGNATURE_ALGORITHM = "SHA256withECDSA";
    private static final String PROVIDER = "BC";

    private static KeyPairGenerator keyGen_;
    private static SecureRandom random;

    public void run(Signature signature,KeyPair myKeyPair, String password) throws Exception {

        String skFilename = "Scrooge" + "_sk.pem";
        Security.addProvider(new BouncyCastleProvider());
        String messageStr1 = "Pay 3 bitcoins to Alice";
        byte[] message1 = messageStr1.getBytes(StandardCharsets.UTF_8);
        signature.update(message1);
        byte[] sigBytes1 = signature.sign();
        PrivateKey recoveredKey = loadSecretKeyFromEncrypted(skFilename, password);

        System.out.println("recoveredKey.getAlgorithm()=" + recoveredKey.getAlgorithm());
        System.out.println();

        signature.update(message1);
        System.out.println("Signature: msg=" + messageStr1 + " sig.len=" + sigBytes1.length );
         System.out.println("Sig=" + DatatypeConverter.printHexBinary(sigBytes1));

    }

    public static PrivateKey loadSecretKeyFromEncrypted(String filename, String password) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, PKCSException, OperatorCreationException {
		File secretKeyFile = new File(filename); // private key file in PEM format
		PEMParser pemParser = new PEMParser(new FileReader(secretKeyFile));
		Object object = pemParser.readObject();
		PEMDecryptorProvider decProv = new JcePEMDecryptorProviderBuilder().build(password.toCharArray());
		JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
		KeyPair kp = converter.getKeyPair(((PEMEncryptedKeyPair) object).decryptKeyPair(decProv));
		return kp.getPrivate();
	}

    public static void main(String[] args) throws Throwable {
        // String content, String filename, String password
        Security.addProvider(new BouncyCastleProvider());
        random = SecureRandom.getInstanceStrong();
        //Initialize the key
        keyGen_ = KeyPairGenerator.getInstance(KEY_ALGORITHM, PROVIDER);

        KeyPair kp = keyGen_.generateKeyPair();

        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(kp.getPrivate(), random);
        new GenerateDigitalSignature().run(signature, kp,"testScrooge");
    }

}
