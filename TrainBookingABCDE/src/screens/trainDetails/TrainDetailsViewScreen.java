package screens.trainDetails;

import dto.Passenger;
import dto.Train;

import java.util.List;
import java.util.Queue;

public class TrainDetailsViewScreen {
    private TrainDetailsViewModel viewModel;
    public TrainDetailsViewScreen(){
        this.viewModel=new TrainDetailsViewModel(this);
    }

    public Train onCreateTrain() {
        return viewModel.onCreateTrains();
    }

    public void printTrainDetails(Train t) {

            System.out.println("Total Confirm Seat : "+t.getAvailableConfirmSeat());
            System.out.println("Available Waiting Seat : "+t.getAvailableWaitingSeat());
        System.out.println("___________________________________");
        int[] temp=t.getBookedSeats();
        System.out.println("Booked Confirm Seat based on the location : ");
        System.out.println("A B C D E");
        for(int i=0;i<5;i++){
                System.out.print(temp[i]+" ");
        }
        System.out.println();
        System.out.println("___________________________________");

    }

    public void printBookedTicket(Train train) {
        List<Passenger> confirmedTickets=train.getBookedTickets();
        int ticketCount=1;
        for(Passenger p:confirmedTickets){
            System.out.println("Ticket No : "+ticketCount++);
            printPassenegrDetails(p);

        }

        Queue<Passenger> waitingList=train.getWaitingList();
        if(waitingList.size()>0)
        System.out.println("Waiting List : ");
        for(Passenger p:waitingList){
            printPassenegrDetails(p);
        }
    }
    public void printPassenegrDetails(Passenger p){
        System.out.println("Passenger PNR : "+p.getPNR()+" Source : "+p.getSource()+" Destination : "+p.getDestination()+" Booked Tickets "+p.getBookingTickets());
        List<String> passengerName=p.getName();
        List<Integer> passengerAge=p.getAge();
        System.out.println("Passeneger Name  &Age");
        for(int i=0;i<passengerAge.size();i++){
            System.out.println(passengerName.get(i)+"-"+passengerAge.get(i));
        }
        System.out.println();
        System.out.println("*********************************");

    }
}
