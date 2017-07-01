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
public class Teacher {
    private String lastName;
    private String firstName;
    private ArrayList<Course>allCourse;
    
    private String gender;
    private String phoneNumber;
    private String address;
    private String teacherID;
    
    
    public Teacher(){
        this.allCourse = new ArrayList<Course>();
       
    }
    
    public Teacher(String lastname,String firstname,String teacherID,String gender,String phoneNumber,String address){
        /*this.lastName = lastname;
        this.firstName = firstname;
        this.studentID =  studentID;
        this.active = active;*/
        this();
        this.setLastName(lastname);
        this.setFirstName(firstname);
        this.setTeacherID(teacherID);
        this.setGender(gender);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
    }

    public ArrayList<Course> getAllCourse() {
        return allCourse;
    }

    public void setAllCourse(ArrayList<Course> allCourse) {
        this.allCourse = allCourse;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Name=" + lastName + " " + firstName + ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", teacherID=" + teacherID;
    }

    
}
