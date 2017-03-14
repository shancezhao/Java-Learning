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
public class House {
    
    private int HouseNumber;
    private double RiskScore;
    private ArrayList<Family> allFamily;
    
    public House(){
        this.allFamily = new ArrayList<Family>();
    }
    public House(int HouseNumber){
        this();
        this.setHouseNumber(HouseNumber);
    }

   
    public void setHouseNumber(int HouseNumber) {
        this.HouseNumber = HouseNumber;
    }

    public ArrayList<Family> getAllFamily() {
        return allFamily;
    }

    public void setAllFamily(ArrayList<Family> allFamily) {
        this.allFamily = allFamily;
    }

    public double getRiskScore() {
        return RiskScore;
    }

    public void setRiskScore(double RiskScore) {
        this.RiskScore = RiskScore;
    }

    
    @Override
    public String toString() {
        return "House Number:"+ HouseNumber+";\nHouse Risk: "+RiskScore;
    }
       
}
