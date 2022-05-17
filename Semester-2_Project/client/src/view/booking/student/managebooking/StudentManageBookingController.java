package view.booking.student.managebooking;

import booking.Booking;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import view.ViewHandler;
import viewModel.booking.StudentManageBookingViewModel;

public class StudentManageBookingController {
    @FXML
    private ListView<Booking> bookingList;
    public void init(ViewHandler viewHandler, StudentManageBookingViewModel studentManageBookingViewModel) {
    }
    public void cancelBooking(){
        //
    }
}
