/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import javax.swing.Icon;

/**
 *
 * @author mac
 */
public class Resume {
    
    private String Firstname;
    private String Lastname;
    private long phonenum;
    private String gender;
    private String workhistory;
    private String ability;
    
    private Icon icon;
    
    private String address_1;
    private String addresschoice;
    private String address_city;
    
    private String affiliation;
    private String carreerobjst;
    
    private String edu_highcombox;
    private String edu_undercombox;
    private String edu_gradcombox;

    private String edu_high;
    private String edu_under;
    private String edu_graduate;
    
    private String current;
    
    private String email;

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddresschoice() {
        return addresschoice;
    }

    public void setAddresschoice(String addresschoice) {
        this.addresschoice = addresschoice;
    }


    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getCarreerobjst() {
        return carreerobjst;
    }

    public void setCarreerobjst(String carreerobjst) {
        this.carreerobjst = carreerobjst;
    }

    public String getEdu_high() {
        return edu_high;
    }

    public void setEdu_high(String edu_high) {
        this.edu_high = edu_high;
    }

    public String getEdu_under() {
        return edu_under;
    }

    public void setEdu_under(String edu_under) {
        this.edu_under = edu_under;
    }

    public String getEdu_graduate() {
        return edu_graduate;
    }

    public void setEdu_graduate(String edu_graduate) {
        this.edu_graduate = edu_graduate;
    }

    public String getEdu_highcombox() {
        return edu_highcombox;
    }

    public void setEdu_highcombox(String edu_highcombox) {
        this.edu_highcombox = edu_highcombox;
    }

    public String getEdu_undercombox() {
        return edu_undercombox;
    }

    public void setEdu_undercombox(String edu_undercombox) {
        this.edu_undercombox = edu_undercombox;
    }

    public String getEdu_gradcombox() {
        return edu_gradcombox;
    }

    public void setEdu_gradcombox(String edu_gradcombox) {
        this.edu_gradcombox = edu_gradcombox;
    }

    public long getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(long phonenum) {
        this.phonenum = phonenum;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWorkhistory() {
        return workhistory;
    }

    public void setWorkhistory(String workhistory) {
        this.workhistory = workhistory;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     @Override   //run time polymorphism
    public String toString()
    {
        return this.Firstname;
    }
    
}
