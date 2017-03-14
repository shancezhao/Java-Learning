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
public class HouseDirectory {
     
    private ArrayList<House> houseDirectory;
    
    public HouseDirectory(){
        houseDirectory=new ArrayList<House>();
    }

    public ArrayList<House> getHouseDirectory() {
        return houseDirectory;
    }

    public void setHouseDirectory(ArrayList<House> houseDirectory) {
        this.houseDirectory = houseDirectory;
    }

    public House addHouse(House house){
        houseDirectory.add(house);
        return house;
    }
    
    
    
}
