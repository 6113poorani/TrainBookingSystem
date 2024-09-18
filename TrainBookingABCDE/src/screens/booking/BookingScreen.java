package screens.booking;

import dto.Passenger;
import dto.Train;
import screens.trainDetails.TrainDetailsViewScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BookingScreen {
    private BookingViewModel viewModel;
    public BookingScreen(){
        this.viewModel=new BookingViewModel(this);
    }

    public void onCreate() {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter the Source Station : ");
       char src=scn.next().charAt(0);
        System.out.println("Enter the Destination Station : ");
        char dst=scn.next().charAt(0);
        System.out.println("Enter the no.of tickets do you want : ");
        int tickets=scn.nextInt();
        if(src=='E'||src>dst||tickets>Train.getInstance().getAvailableConfirmSeat()){
            System.out.println("Wrong choice ");
            return;
        }

        viewModel.checkAvailable(src,dst,tickets);

    }

    public void navigateToFailure() {
        System.out.println("Tickets are not available");

    }

    public void navigateToSuccess(char src,char dst,int tickets,String type) {
       Scanner scn=new Scanner(System.in);
        Passenger passenger=new Passenger();
        passenger.setPNR();
        passenger.setBookingTickets(tickets);
        passenger.setSource(src);
        passenger.setDestination(dst);
        List<String> nameList=passenger.getName();
        List<Integer> ageList=passenger.getAge();
        for(int i=0;i<tickets;i++){
            System.out.println("Enter passenger Name :");
            nameList.add(scn.next());
            System.out.println("Enter passenger Age :");
            ageList.add(scn.nextInt());
        }
        passenger.setName(new ArrayList<>(nameList));
        passenger.setAge(new ArrayList<>(ageList));
        if(type.equals("CT")) {
            List<Passenger> ct = Train.getInstance().getBookedTickets();
            ct.add(passenger);
            Train.getInstance().setBookedTickets(ct);

            System.out.println("Booked Successfully");
            System.out.println("Your PNR will be : "+passenger.getPNR());
            TrainDetailsViewScreen trainDetailsViewScreen=new TrainDetailsViewScreen();
            trainDetailsViewScreen.printPassenegrDetails(passenger);
        }
        else{
            Queue<Passenger> wt=Train.getInstance().getWaitingList();
            wt.add(passenger);
            Train.getInstance().setWaitingList(wt);
            System.out.println("You are Booked in Waiting List");
            System.out.println("Ypur PNR will be : "+passenger.getPNR());
            int wl=Train.getInstance().getAvailableWaitingSeat();
            Train.getInstance().setAvailableWaitingSeat(wl-tickets);
        }


    }
}
