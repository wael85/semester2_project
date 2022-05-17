package view.booking.student.checkin;

import booking.Booking;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import view.ViewHandler;
import viewModel.booking.CheckInViewModel;

public class CheckInController {
    @FXML
    private ListView<Booking> bookingList;
    public void init(ViewHandler viewHandler, CheckInViewModel checkInViewModel) {
    }
}
