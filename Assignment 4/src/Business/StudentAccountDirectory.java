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
public class StudentAccountDirectory {
    
    private ArrayList<StudentAccount>studentAccountList;
    
    public StudentAccountDirectory(){
        
        studentAccountList = new ArrayList<StudentAccount>(); 
    }

    public ArrayList<StudentAccount> getStudentAccountList() {
        return studentAccountList;
    }

    public void setStudentAccountList(ArrayList<StudentAccount> studentAccountList) {
        this.studentAccountList = studentAccountList;
    }
    
    
}
