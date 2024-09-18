package dto;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private static int id=1;
    private int PNR;
    private int bookingTickets;
    private List<String> name;
    private List<Integer> age;
    private int totalCost;
    private char source;
    private char destination;

    public int getBookingTickets() {
        return bookingTickets;
    }
    public Passenger(){
        this.name=new ArrayList<>();
        this.age=new ArrayList<>();
    }
    public int getPNR() {
        return PNR;
    }

    public void setPNR() {
        this.PNR = id++;
    }
    public char getSource() {
        return source;
    }

    public void setSource(char source) {
        this.source = source;
    }

    public char getDestination() {
        return destination;
    }

    public void setDestination(char destination) {
        this.destination = destination;
    }

    public void setBookingTickets(int bookingTickets) {
        this.bookingTickets = bookingTickets;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<Integer> getAge() {
        return age;
    }

    public void setAge(List<Integer> age) {
        this.age = age;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
