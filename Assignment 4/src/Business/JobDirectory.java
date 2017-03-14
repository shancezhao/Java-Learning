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
public class JobDirectory {
    private ArrayList <Job> jobDirectory;
    
    public JobDirectory(){
        jobDirectory=new ArrayList <Job>();
    }
    public ArrayList<Job> getJob(){
        return jobDirectory;
    }
    public void setJobDirectory(ArrayList <Job> jobDirectory){
        this.jobDirectory = jobDirectory;
    }
}
