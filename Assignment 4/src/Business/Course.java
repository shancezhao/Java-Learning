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
public class Course {
    private String courseName;
    private int CRN;
    private String courseType;
    private int credit;
    private Department department;
    private Transcript transcript;
    private Teacher teacher;
    private Classroom classroom;
    private Semester semester;
    private StudentDirectory allStudents;
    
    public Course(){    //No arguments constructs
        this.teacher = new Teacher();
        this.classroom = new Classroom();
        allStudents = new StudentDirectory(); 
        this.transcript = new Transcript();
        this.semester= new Semester();
         }
    //instantiate Course
    public Course(String courseName, int CRN, String courseType, int credit){
        
        this() ;  
        this.setCourseName(courseName);
        this.setCRN(CRN);
        this.setCourseType(courseType);
        this.setCredit(credit);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    

    public int getCRN() {
        return CRN;
    }

    public void setCRN(int CRN) {
        this.CRN = CRN;
    }
    
    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    public Semester getSemester() {
        return semester;
    }

    public void setSemester( Semester semester) {
        this.semester = semester;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public StudentDirectory getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(StudentDirectory allStudents) {
        this.allStudents = allStudents;
    }

    @Override
    public String toString() {
        return "Course Name:" + courseName + ", CRN:" + CRN + ", course type:" + courseType + ", credit:" + credit + ", department:" + department + ", teacher:" + teacher.getLastName()+" "+teacher.getFirstName() + ", classroom " + classroom.toString() + ". semester=" + semester;
        
    }
    
    
}
