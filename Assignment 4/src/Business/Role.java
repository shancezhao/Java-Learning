/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author ChaiYi
 */
public class Role {
   private String roletype;
   private Job job;

    public String getRoletype() {
        return roletype;
    }

    public void setRoletype(String roletype) {
        this.roletype = roletype;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
    
}
