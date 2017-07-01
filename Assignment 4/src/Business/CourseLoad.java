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
public class CourseLoad {
    private Student student;
    private Semester givenSemester;
    private ArrayList<Course> allcourse;
  

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semester getGivenSemester() {
        return givenSemester;
    }

    public void setGivenSemester(Semester givenSemester) {
        this.givenSemester = givenSemester;
    }

    public ArrayList<Course> getAllcourse() {
        return allcourse;
    }

    public void setAllcourse(ArrayList<Course> allcourse) {
        this.allcourse = allcourse;
    }
    
        
    
}
