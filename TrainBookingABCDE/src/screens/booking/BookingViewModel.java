package screens.booking;

import dto.Train;

public class BookingViewModel {
    private BookingScreen view;
    BookingViewModel(BookingScreen bookingScreen){
        this.view=bookingScreen;
    }

    public void checkAvailable(char src,char dst,int tickets) {
        int[] tempBookedSeats= Train.getInstance().getBookedSeats();
        int totalTickets=Train.getInstance().getAvailableConfirmSeat();
        int source=src-'A';
        int destination=dst-'A';
       for(int i=source;i<destination;i++){
           if(tempBookedSeats[i]==totalTickets||totalTickets-tickets<0) {
               checkWaitingList(src,dst,tickets);
               return;
           }
           else{
               tempBookedSeats[i]+=tickets;
           }
       }
       Train.getInstance().setBookedSeats(tempBookedSeats);
       view.navigateToSuccess(src,dst,tickets,"CT");

    }

    private void checkWaitingList(char src,char dst,int tickets) {
       int waitingList= Train.getInstance().getAvailableWaitingSeat();
       if(waitingList==0||waitingList-tickets<0){
           view.navigateToFailure();
           return;
       }
       view.navigateToSuccess(src,dst,tickets,"WT");

    }
}
