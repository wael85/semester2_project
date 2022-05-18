package view.booking.student.checking;

import booking.Booking;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import view.ViewHandler;
import viewModel.booking.CheckInViewModel;

public class CheckInController {
    @FXML
    private ListView<Booking> bookingList;

    private CheckInViewModel checkInViewModel;
    private  ViewHandler viewHandler;
    public void init(ViewHandler viewHandler, CheckInViewModel checkInViewModel) {
        this.checkInViewModel = checkInViewModel;
        this.viewHandler=viewHandler;
    }
}
