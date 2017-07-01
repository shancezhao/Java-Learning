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
public class ClassroomDirectory {
    private ArrayList <Classroom> classroomDirectory;
    
    public ClassroomDirectory(){
        classroomDirectory=new ArrayList<Classroom>();
    }
    public ArrayList <Classroom> getCollege(){
        return classroomDirectory;
    }
    public void setClassroomDirectory(ArrayList <Classroom> classroomDirectory){
        this.classroomDirectory=classroomDirectory;
    }
    
    public Classroom addClass(Classroom classroom){
        classroomDirectory.add(classroom);
        return classroom;      
    }
}
