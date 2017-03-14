/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kaiyingzhang
 */
public class Student {
    private String lastName;
    private String firstName;
    private long studentID;
    private String gender;
    private int phoneNumber;
    private String address;
    private University university;
    private College college;
    private Department department;
    //private int CRN;//class number
    private List<Course> allCourses ;
    //private int Grade;
    
    private int active;  
    //-1:accidents 0:studying 1:after graduate
    private int status;
    //0:don't find a job 1:be on the job
    
    //private University university;
    private Transcript transcript;//???
    
    public Student(){
        this.allCourses = new ArrayList<Course>() ;
        this.department = new Department();
        this.university = new University();
    }

    public Student(String lastname,String firstname,long studentID,int status,int active,String gender,int phoneNumber,String address){
        /*this.lastName = lastname;
        this.firstName = firstname;
        this.studentID =  studentID;
        this.active = active;*/
        this();
        this.setLastName(lastname);
        this.setFirstName(firstname);
        this.setStudentID(studentID);
        this.setActive(active);
        this.setGender(gender);
        this.setAddress(address);
        this.setStatus(status);
        this.setPhoneNumber(phoneNumber);
        
        
        
    }
    
    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public List<Course> getAllCourses() {
        return allCourses;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
   
    public String toString(){   
        return "\n\t|-Name:" + this.lastName+" "+this.firstName + "；StudentID:" + this.studentID+" "+"; Department:"+this.department +"; PhoneNumber:"+this.phoneNumber;              
    }        
    
}
