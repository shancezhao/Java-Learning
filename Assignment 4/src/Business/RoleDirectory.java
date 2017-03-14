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
public class RoleDirectory {
    private ArrayList <Role> RoleDirectory;
    
    public RoleDirectory(){
    RoleDirectory=new ArrayList <Role>();
    }

    public ArrayList<Role> getRoleDirectory() {
        return RoleDirectory;
    }

    public void setRoleDirectory(ArrayList<Role> RoleDirectory) {
        this.RoleDirectory = RoleDirectory;
    }
    
    
    
}
