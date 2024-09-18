
import dto.Train;
import screens.booking.BookingScreen;
import screens.cancel.CancelScreen;
import screens.trainDetails.TrainDetailsViewScreen;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        boolean loop=true;
        TrainDetailsViewScreen trainDetailsViewScreen=new TrainDetailsViewScreen();
        Train train=trainDetailsViewScreen.onCreateTrain();
        while(loop){
            System.out.println("Enter Your Choice \n1.Book \n2.Cancel \n3.print Train Details \n4.print Booked Tickets details\n5.Exit");
            Scanner scn=new Scanner(System.in);
            int choice=scn.nextInt();
            switch(choice){
                case 1:{
                    BookingScreen bookingScreen=new BookingScreen();
                    bookingScreen.onCreate();
                    break;
                }
                case 2:{
                    CancelScreen cancelScreen=new CancelScreen();
                    cancelScreen.onCreate();
                    break;
                }
                case 3:{
                    trainDetailsViewScreen.printTrainDetails(train);
                    break;
                }
                case 4:{
                  trainDetailsViewScreen.printBookedTicket(train);
                    break;
                }
                case 5:{
                    loop=false;
                    break;
                }
            }
        }
    }
}