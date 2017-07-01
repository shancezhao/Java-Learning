/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author ChaiYi
 */
public class UniversityDirectory {
    private ArrayList<University> universityDirectory;
    
    public UniversityDirectory(){
        universityDirectory=new ArrayList<University>();
    }

    public ArrayList<University> getUniversityDirectory() {
        return universityDirectory;
    }

    public void setUniversityDirectory(ArrayList<University> universityDirectory) {
        this.universityDirectory = universityDirectory;
    }
    
    
}
