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
public class Seat {
    private Classroom classroom;
    private int seatNumber;
    
    public Seat(int seatNumber){
        this.setSeatNumber(seatNumber);
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Seat{" + "classroom=" + classroom + ", seatNumber=" + seatNumber + '}';
    }
    
}
