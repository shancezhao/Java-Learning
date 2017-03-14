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
public class CourseLoadDirectory {
    private ArrayList <CourseLoad> CourseLoadDirectory;
    
    public CourseLoadDirectory(){
        CourseLoadDirectory=new ArrayList <CourseLoad>();
    }

    public ArrayList<CourseLoad> getCourseLoadDirectory() {
        return CourseLoadDirectory;
    }

    public void setCourseLoadDirectory(ArrayList<CourseLoad> courseLoadDirectory) {
        this.CourseLoadDirectory = courseLoadDirectory;
    }
    
    
}
