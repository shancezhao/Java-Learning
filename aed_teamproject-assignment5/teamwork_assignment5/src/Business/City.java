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
public class City {
   private String cityName;   
   private ArrayList<Community>community;
   
   public City(){
       this.community= new ArrayList<Community>();
   }
   
   public City(String cityName){
       this();
       this.setCityName(cityName);
   }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public ArrayList<Community> getCommunity() {
        return community;
    }

    public void setCommunity(ArrayList<Community> community) {
        this.community = community;
    }

    
    
    @Override
    public String toString() {
        return "City Name:"+ cityName+";\nCity Members: \n"+community;
    }
    
}
