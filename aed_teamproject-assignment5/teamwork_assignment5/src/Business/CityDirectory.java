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
public class CityDirectory {
    private ArrayList<City>cityDirectory;
    
    public CityDirectory(){
        cityDirectory = new ArrayList<City>();
    }

    public ArrayList<City> getCityDirectory() {
        return cityDirectory;
    }

    public void setCityDirectory(ArrayList<City> cityDirectory) {
        this.cityDirectory = cityDirectory;
    }
   
    public City addCity(City city){
        cityDirectory.add(city);
        return city;
    }
    
}
