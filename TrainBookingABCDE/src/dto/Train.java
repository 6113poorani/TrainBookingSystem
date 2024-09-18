package dto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Train {
    private static Train train;

    private int availableConfirmSeat;
    private int availableWaitingSeat;
    private int[] bookedSeats;
    private Train(){

    }
    public static Train getInstance(){
        if(train==null){
            return train=new Train();
        }
        return train;
    }

    private List<Passenger> bookedTickets=new ArrayList<>();
    private Queue<Passenger> waitingList=new LinkedList<>();

    public int getAvailableConfirmSeat() {
        return availableConfirmSeat;
    }

    public void setAvailableConfirmSeat(int availableConfirmSeat) {
        this.availableConfirmSeat = availableConfirmSeat;

    }

    public int getAvailableWaitingSeat() {
        return availableWaitingSeat;
    }

    public void setAvailableWaitingSeat(int availableWaitingSeat) {
        this.availableWaitingSeat = availableWaitingSeat;
    }

    public int[] getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int[] bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public List<Passenger> getBookedTickets() {
        return bookedTickets;
    }

    public void setBookedTickets(List<Passenger> bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

    public Queue<Passenger> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(Queue<Passenger> waitingList) {
        this.waitingList = waitingList;
    }

}
