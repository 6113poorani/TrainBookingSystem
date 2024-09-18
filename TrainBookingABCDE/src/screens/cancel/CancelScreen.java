package screens.cancel;

import dto.Passenger;
import dto.Train;
import screens.trainDetails.TrainDetailsViewScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CancelScreen {
    private CancelViewModel viewModel;
    public CancelScreen(){
        this.viewModel=new CancelViewModel(this);
    }

    public void onCreate() {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter Your PNRNo");
        int pnr=scn.nextInt();
        viewModel.isValidPNR(pnr);

    }


    public void navigateToCancel(int i, Passenger p){
        TrainDetailsViewScreen trainDetailsViewScreen=new TrainDetailsViewScreen();
        trainDetailsViewScreen.printPassenegrDetails(p);
        Scanner scn=new Scanner(System.in);
        System.out.println("How many tickets Do you want to cancel ? ");
        int cancelTickets=scn.nextInt();
        if(cancelTickets<0||cancelTickets>p.getBookingTickets()){
            System.out.println("Enter valid Tickets");
            return;
        }
        viewModel.removeSeats(p,cancelTickets);
        List<Passenger> bookedTickets= Train.getInstance().getBookedTickets();
        bookedTickets.remove(i);
        Train.getInstance().setBookedTickets(bookedTickets);

        if(cancelTickets<p.getBookingTickets())
            removePassenger(p,cancelTickets);

        System.out.println("Tickets Cancelled Successfully!!!*********");
        viewModel.checkWaitingList();

    }

    private void removePassenger(Passenger p, int cancelTickets) {
        Scanner scn=new Scanner(System.in);
        List<String> passengerName=p.getName();
        List<Integer> passengerAge=p.getAge();
        for(int i=0;i<cancelTickets;i++){
            System.out.println("Enter Passeneger Name and Age : ");
            String name=scn.next();
            passengerName.remove(name);
            int age=scn.nextInt();
            passengerAge.remove(Integer.valueOf(age));
        }
        p.setName(new ArrayList<>(passengerName));
        p.setAge(new ArrayList<>(passengerAge));
        p.setBookingTickets(p.getBookingTickets()-cancelTickets);
        List<Passenger> bookedTickets= Train.getInstance().getBookedTickets();
        bookedTickets.add(p);
        Train.getInstance().setBookedTickets(bookedTickets);

    }


    public void navigateToWrongPNR() {
        System.out.println("Enter the valid PNR number");
    }
}
