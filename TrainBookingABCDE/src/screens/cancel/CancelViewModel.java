package screens.cancel;

import dto.Passenger;
import dto.Train;
import screens.trainDetails.TrainDetailsViewScreen;

import java.util.List;
import java.util.Queue;

public class CancelViewModel {
    private CancelScreen view;
    CancelViewModel(CancelScreen view){
        this.view=view;
    }

    public void isValidPNR(int pnr) {
        List<Passenger> train=Train.getInstance().getBookedTickets();
        int i=0;
        for(Passenger p:train){
            if(p.getPNR()==pnr){
                view.navigateToCancel(i,p);
                return;
            }
            i++;
        }
        view.navigateToWrongPNR();
    }


    public void removeSeats(Passenger p, int cancelTickets) {
        int[] bookedSeats=Train.getInstance().getBookedSeats();
        int src=p.getSource()-'A';
        int dst=p.getDestination()-'A';
        for (int i=src;i<dst;i++){
            bookedSeats[i]-=cancelTickets;
        }
        Train.getInstance().setBookedSeats(bookedSeats);
    }

    public void checkWaitingList() {
        Queue<Passenger> passengers=Train.getInstance().getWaitingList();
        List<Passenger> ct=Train.getInstance().getBookedTickets();
        int len=passengers.size();
      while(len-->0){
          Passenger p=passengers.poll();
          if(!checkAvailable(p.getSource(),p.getDestination(),p.getBookingTickets())){
              passengers.add(p);
          }
         else{
              System.out.println("Waiting List moved to confirm List !!!");
              TrainDetailsViewScreen trainDetailsViewScreen=new TrainDetailsViewScreen();
              trainDetailsViewScreen.printPassenegrDetails(p);
             ct.add(p);
          }
      }
      Train.getInstance().setBookedTickets(ct);
      Train.getInstance().setWaitingList(passengers);

    }
    public boolean checkAvailable(char src,char dst,int tickets) {
        int[] tempBookedSeats= Train.getInstance().getBookedSeats();
        int totalTickets=Train.getInstance().getAvailableConfirmSeat();
        int source=src-'A';
        int destination=dst-'A';
        for(int i=source;i<destination;i++){
            if(tempBookedSeats[i]==totalTickets||totalTickets-tickets<0) {

                return false;
            }
            else{
                tempBookedSeats[i]+=tickets;
            }
        }
        Train.getInstance().setBookedSeats(tempBookedSeats);
        return true;
    }

}
