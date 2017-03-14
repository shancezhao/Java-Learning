/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kaiyingzhang
 */
public class PersonDirectory {
    private ArrayList<Person>personDirectory;
    
    public PersonDirectory(){
        personDirectory = new ArrayList<Person>();
    }

    public ArrayList<Person> getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(ArrayList<Person> personDirectory) {
        this.personDirectory = personDirectory;
    }
    
    public Person addPerson(Person p){
        personDirectory.add(p);
        return p;
    }
    
    public Person deletePerson(Person p){
        personDirectory.remove(p);
        return p;
    }
    public void giveAge(Person p){
        int max=90;
        int min=1;
        Random random = new Random();
        int age = random.nextInt(max)%(max-min+1) + min;
        System.out.print(age);
        p.setAge(age);
       // this.personDirectory.add(p);
    }
    
}
