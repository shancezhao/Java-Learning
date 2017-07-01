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
public class Classroom {
    private int classroomNumber;
    private String building;
    private ArrayList<Seat> allSeat;

    private ArrayList<Course> allCourse;
    //One Classroom has many seats
    public Classroom(){
        this.allCourse = new ArrayList<Course>();
        this.allSeat = new ArrayList<Seat>();
    }
    public Classroom(String building,int classroomNumber){
        this();
        this.setBuilding(building);
        this.setClassroomNumber(classroomNumber);
    }

    public int getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(int classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public ArrayList<Seat> getAllSeat() {
        return allSeat;
    }

    public void setAllSeat(ArrayList<Seat> allSeat) {
        this.allSeat = allSeat;
    }

    public ArrayList<Course> getAllCourse() {
        return allCourse;
    }

    public void setAllCourse(ArrayList<Course> allCourse) {
        this.allCourse = allCourse;
    }

    
    @Override
    public String toString() {
        return "location: " + classroomNumber + ", " + building;
    }
    
    
}
