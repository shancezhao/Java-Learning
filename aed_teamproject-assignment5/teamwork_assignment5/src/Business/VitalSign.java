/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Shance
 */
public class VitalSign {
 //   private Person person;
    private int diabetes;
    private int pressure;
    private int smoke;
    private int height;
    private int weight;
    private int totalCho;
    private int HDLCho;
    private int LDLcho;
    private int heartbeat;
    private int diastolicPressure;
    
/*   public VitalSign(){
        this.person=new Person();
    }
*/
    public VitalSign(int diabetes,int pressure,int smoke,int height,int weight,int totalCho,int HDLCho,int heartbeat,int LDLCho,int diastolicPressure){
     //   this();
        this.setPressure(pressure);
        this.setSmoke(smoke);
        this.setHeight(height);
        this.setWeight(weight);
        this.setTotalCho(totalCho);
        this.setHDLCho(HDLCho);
        this.setHeartbeat(heartbeat);
        this.setDiastolicPressure(diastolicPressure);
        this.setLDLcho(LDLCho);
    }
   
    public int getDiabetes() {
        return diabetes;
    }

/*
    public Person getPerson() {
    return person;
    }
    public void setPerson(Person person) {
    this.person = person;
    }
     */   
    public void setDiabetes(int diabetes) {
        this.diabetes = diabetes;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getSmoke() {
        return smoke;
    }

    public void setSmoke(int smoke) {
        this.smoke = smoke;
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTotalCho() {
        return totalCho;
    }

    public void setTotalCho(int totalCho) {
        this.totalCho = totalCho;
    }

    public int getHDLCho() {
        return HDLCho;
    }

    public void setHDLCho(int HDLCho) {
        this.HDLCho = HDLCho;
    }

    public int getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(int heartbeat) {
        this.heartbeat = heartbeat;
    }

    public int getLDLcho() {
        return LDLcho;
    }

    public void setLDLcho(int LDLcho) {
        this.LDLcho = LDLcho;
    }

    public int getDiastolicPressure() {
        return diastolicPressure;
    }

    public void setDiastolicPressure(int diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }
    
    

    @Override
    public String toString() {
        return "VitalSign{" + "pressure=" + pressure + ", diastolic=" + diastolicPressure + ",smoke=" + smoke + ", height=" + height + ", weight=" + weight + ", totalCho=" + totalCho + ", HDLCho=" + HDLCho + ",LDLCho=" + LDLcho + ", heartbeat=" + heartbeat + '}';
    }
    
}
