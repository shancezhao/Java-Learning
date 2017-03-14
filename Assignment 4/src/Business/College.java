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
public class College {
    private String collegeName;
    private StudentDirectory allStudents;
    private ArrayList<Department> departments;
 //   private ArrayList<University> universitys;
    
    
    public College(String collegeName){
        allStudents = new StudentDirectory(); 
        this.departments=new ArrayList<Department>();
 //       this.universitys=new ArrayList<University>();
        this.setCollegeName(collegeName);
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public StudentDirectory getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(StudentDirectory allStudents) {
        this.allStudents = allStudents;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }
/*
    public ArrayList<University> getUniversitys() {
        return universitys;
    }

    public void setUniversitys(ArrayList<University> universitys) {
        this.universitys = universitys;
    }
    
*/
    @Override
    public String toString() {
        return "\n\t|-collegeName:" + collegeName + ", departments=" + departments ;
    }
  
}
