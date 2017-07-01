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
public class SemesterDirectory {
    private ArrayList <Semester> semesterDirectory;
    public SemesterDirectory(){
        semesterDirectory = new ArrayList<Semester>();
    }
    public ArrayList<Semester> getSemester(){
        return semesterDirectory;
    }
    public void setSemester(ArrayList <Semester> semesterDirectory){
        this.semesterDirectory=semesterDirectory;
    }
}
