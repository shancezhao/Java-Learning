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
public class Department {
    
    private String depName;
    private ArrayList<Course> allcourses;

    private StudentDirectory allStudents;
    private ArrayList<Job> jobs;
    private College college;
               
    public Department(){
      
       this.jobs=new ArrayList<Job>();
       this.allcourses = new ArrayList<Course>();
       allStudents = new StudentDirectory(); 
       
    }
    
    public Department(String depName){  
        this();
        this.setDepName(depName);
        //this.allStudents = new ArrayList<Student>(); 
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    public StudentDirectory getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(StudentDirectory allStudents) {
        this.allStudents = allStudents;
    }

    
    public ArrayList<Course> getAllcourses() {
        return allcourses;
    }

    public void setAllcourses(ArrayList<Course> allcourses) {
        this.allcourses = allcourses;
    }
        
    @Override
    public String toString() {
        return this.depName;
    }

    
}
