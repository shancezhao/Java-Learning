/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author kaiyingzhang
 */
public class FamilyDirectory {
    private ArrayList<Family>familyDirectory;
    
    private ArrayList<Family>familyDir;
    
    public FamilyDirectory(){
        familyDirectory = new ArrayList<Family>();      
    }
   

    public ArrayList<Family> getFamilyDirectory() { 
        return familyDirectory;
    }

    public void setFamilyDirectory(ArrayList<Family> familyDirectory) {
        this.familyDirectory = familyDirectory;
    }
    
    public Family addFamily(Family family){
        familyDirectory.add(family);
        return family;
    }
    
    
}
