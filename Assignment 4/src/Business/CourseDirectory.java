   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class CourseDirectory {
    private ArrayList <Course> courseDirectory;
    
    public CourseDirectory(){
        courseDirectory=new ArrayList<Course>();
    }
    public ArrayList <Course> getCollege(){
        return courseDirectory;
    }
    public void setCourseDirectory(ArrayList <Course> courseDirectory){
        this.courseDirectory=courseDirectory;
    }

}
