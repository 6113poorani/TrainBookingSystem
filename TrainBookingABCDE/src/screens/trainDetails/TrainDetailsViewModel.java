package screens.trainDetails;

import dto.Train;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TrainDetailsViewModel {
    private TrainDetailsViewScreen view;
    TrainDetailsViewModel(TrainDetailsViewScreen trainDetailsViewScreen){
        this.view=trainDetailsViewScreen;
    }

    public Train onCreateTrains() {
        Train t=Train.getInstance();
        t.setAvailableConfirmSeat(2);
        t.setAvailableWaitingSeat(2);

        t.setBookedSeats(new int[5]);
        t.setWaitingList(new LinkedList<>());
        t.setBookedTickets(new ArrayList<>());
        return t;
    }
}
