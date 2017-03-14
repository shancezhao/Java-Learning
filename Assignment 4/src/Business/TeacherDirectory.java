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
public class TeacherDirectory {
    
    private ArrayList<Teacher>teacherDirectory;
    
    public TeacherDirectory(){
        teacherDirectory = new ArrayList<Teacher>();
    }

    public ArrayList<Teacher> getTeacherDirectory() {
        return teacherDirectory;
    }

    public void setTeacherDirectory(ArrayList<Teacher> teacherDirectory) {
        this.teacherDirectory = teacherDirectory;
    }
    
    public Teacher addTeacher(Teacher teacher){
            teacherDirectory.add(teacher);
            return teacher;
    }
    public String getTeacherName(){
        Teacher teacher=new Teacher();
        return teacher.getLastName()+" "+teacher.getFirstName();
    }
    
    
}
