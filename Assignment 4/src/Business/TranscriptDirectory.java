/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Shance
 */
public class TranscriptDirectory {
    private ArrayList<Transcript> transcriptDirectory;
    public TranscriptDirectory(){
        transcriptDirectory = new ArrayList<Transcript>();
    }
    public ArrayList<Transcript> getTranscript(){
        return transcriptDirectory;
    }
    public void setTranscript(ArrayList <Transcript> transcriptDirectory){
        this.transcriptDirectory= transcriptDirectory;
    }
}
