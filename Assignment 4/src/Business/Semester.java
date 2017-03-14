/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Shance
 */
public class Semester {
    private int calenderYear;
    private Date sdate;
    private ArrayList<Course> allCourse;
   
    public Semester(){
        this.allCourse=new ArrayList<Course>();
    }
    
    public Semester(int calenderYear,Date date){
        this();
        this.setCalenderYear(calenderYear); 
        this.sdate=date;
    }

    public int getCalenderYear() {
        return calenderYear;
    }

    public void setCalenderYear(int calenderYear) {
        this.calenderYear = calenderYear;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    
    public ArrayList<Course> getAllCourse() {
        return allCourse;
    }

    public void setAllCourse(ArrayList<Course> allCourse) {
        this.allCourse = allCourse;
    }
    
    

    @Override
    public String toString() {
        //return "Semester{" + "calenderYear=" + calenderYear + ", allCourse=" + allCourse + '}';
        return ("calaenderYear =" +calenderYear + ",date:"+ sdate);
    }
    
}
