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
public class Family {
    
    private long familyNumber;
    private ArrayList<Person>persons;
    private double RiskScore;
    
    public Family(){
        this.persons = new ArrayList<Person>();
    }
    
    public Family(int familyNumber){
       this();
       this.setFamilyNumber(familyNumber);
       
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }
    
    public long getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(long familyNumber) {
        this.familyNumber = familyNumber;
    }

    public double getRiskScore() {
        return RiskScore;
    }

    public void setRiskScore(double RiskScore) {
        this.RiskScore = RiskScore;
    }
    
    @Override
    public String toString() {
        return  "FamilyNumber: " + familyNumber +"\nperson:"+persons+"risk Score:"+RiskScore+";"+ "\n";
     //   return  "FamilyNumber=" + familyNumber +"\n"+"risk Score:"+RiskScore+";";
    }
    
    
    
}
