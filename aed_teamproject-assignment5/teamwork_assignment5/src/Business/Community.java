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
public class Community {
    
    private long communityNumber;
    private double RiskScore;
    private ArrayList<House>allHouse;
    
    public Community(){
       this.allHouse = new ArrayList<House>();
    }
    
    public Community(int communityNumber){
        this();
        this.setCommunityNumber(communityNumber);
    }

    public long getCommunityNumber() {
        return communityNumber;
    }

    public void setCommunityNumber(long communityNumber) {
        this.communityNumber = communityNumber;
    }

   

    public ArrayList<House> getAllHouse() {
        return allHouse;
    }

    public void setAllHouse(ArrayList<House> allHouse) {
        this.allHouse = allHouse;
    }

    public double getRiskScore() {
        return RiskScore;
    }

    public void setRiskScore(double RiskScore) {
        this.RiskScore = RiskScore;
    }
    
    

    @Override
    public String toString() {
        return "Community Number:"+ communityNumber+"; Community Risk Score: "+RiskScore+"\n";
    }
    
}
