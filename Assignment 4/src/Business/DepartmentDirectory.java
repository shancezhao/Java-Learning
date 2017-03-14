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
public class DepartmentDirectory {
    private ArrayList<Department> departmentDirectory;
    
    public DepartmentDirectory(){
        departmentDirectory=new ArrayList<Department>();
    }

    public ArrayList<Department> getDepartmentDirectory() {
        return departmentDirectory;
    }

    public void setDepartmentDirectory(ArrayList<Department> departmentDirectory) {
        this.departmentDirectory = departmentDirectory;
    }
    public Department addDepartment(Department department){
        departmentDirectory.add(department);
        return department;
    }
    
}
