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
public class University {
     private String universityName;
     private int foundingYear;
     private ArrayList<College> colleges;
     private ArrayList<Student> students;
     
     public University(){
     
     
     }
     
 public University(String universityName,int foundingYear){
     this.colleges=new ArrayList<College>();
     this.setUniversityName(universityName);
     this.setFoundingYear(foundingYear);
     this.students=new ArrayList<Student>();
 }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public int getFoundingYear() {
        return foundingYear;
    }

    public void setFoundingYear(int foundingYear) {
        this.foundingYear = foundingYear;
    }

    public ArrayList<College> getColleges() {
        return colleges;
    }

    public void setColleges(ArrayList<College> colleges) {
        this.colleges = colleges;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "**  University **\n" + "universityName:  " + universityName + ";  foundingYear=  " + foundingYear + ";   colleges=  " + colleges + ";   students=" + students + '}';
    }
}
