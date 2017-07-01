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
public class Job {
    private String jobName;
    private ArrayList<Teacher> allTeacher;
    private double salary;
    public Job(String jobName, double salary){
        this.allTeacher = new ArrayList<Teacher>();
        this.setJobName(jobName);
        this.setSalary(salary);
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public ArrayList<Teacher> getAllstudent() {
        return allTeacher;
    }

    public void setAllstudent(ArrayList<Teacher> allTeacher) {
        this.allTeacher = allTeacher;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Job{" + "jobName=" + jobName + ", allstudent=" + allTeacher + ", salary=" + salary + '}';
    }
    
}
