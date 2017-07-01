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
public class StudentDirectory {
    
    private ArrayList<Student>studentDirectory;
    
    public StudentDirectory(){
        studentDirectory = new ArrayList<Student>();
        
    }

    public void setStudentDirectory(ArrayList<Student> studentDirectory) {
        this.studentDirectory = studentDirectory;
    }

    public ArrayList<Student> getStudentDirectory() {
        return studentDirectory;
    }
    
    public int getAllStudentNum(){
        return studentDirectory.size();
    }
    
    public Student addStudent(Student s){
        studentDirectory.add(s);
        return s;   
    }
    /*
    public void removeStudent(Student s){
        studentDirectory.remove(s);       
    }
    */
    
    
}