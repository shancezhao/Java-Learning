/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author kaiyingzhang
 */
public class Person {
    
    private long personId;  
    private String lastName;
    private String firstName;
    private int age;
    private String gender;
    private int CP;
    private int LP;
    private double RISK;
    
    private Family family;
    private VitalSign vitalSign;
    
    private String familyRole;//parents.grandparents.individual.
   /* 
    public Person(){
       // this.vitalSign = new VitalSign(int pressure,int smoke,int height,int weight,int totalCho,int HDLCho,int heartbeat,int LDLCho,int diastolicPressure);
    }

    public Person(long personId,String firstName,String lastName,int age,String gender,String familyRole,int CP,int LP,double RISK)
    {
      //  this();
        this.setPersonId(personId);
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setAge(age);
        this.setGender(gender);      
        this.setFamilyRole(familyRole);
        this.setCP(CP);
        this.setLP(LP);
        this.setRISK(RISK);
    }
*/
    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public VitalSign getVitalSign() {
        return vitalSign;
    }

    public void setVitalSign(VitalSign vitalSign) {
        this.vitalSign = vitalSign;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    public int getLP() {
        return LP;
    }

    public void setLP(int LP) {
        this.LP = LP;
    }

    public double getRISK() {
        return RISK;
    }

    public void setRISK(double RISK) {
        this.RISK = RISK;
    }

    public String getFamilyRole() {
        return familyRole;
    }

    public void setFamilyRole(String familyRole) {
        this.familyRole = familyRole;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
      //  return "Person{" + "personId=" + personId + ", lastName=" + lastName + ", firstName=" + firstName + ", age=" + age + ", gender=" + gender + ",family role ="+familyRole+",VitalSign:"+vitalSign+ ';'+"\n";
      return "Person's INFORMATION:\n personId: " + personId +", Name:"+firstName+" "+lastName+ ", risk score:"+RISK+"\n";
    }
    
    
}
