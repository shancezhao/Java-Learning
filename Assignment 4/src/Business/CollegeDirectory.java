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
public class CollegeDirectory {
    private ArrayList<College> collegeDirectory;
    
    public CollegeDirectory(){
        collegeDirectory=new ArrayList<College>();
    }

    public ArrayList<College> getCollegeDirectory() {
        return collegeDirectory;
    }

    public void setCollegeDirectory(ArrayList<College> collegeDirectory) {
        this.collegeDirectory = collegeDirectory;
    }

   public College addCollege(College college){
       collegeDirectory.add(college);
       return college;
   }
    
    
}
