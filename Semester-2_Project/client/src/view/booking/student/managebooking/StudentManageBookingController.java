package view.booking.student.managebooking;

import booking.Booking;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import view.ViewHandler;
import viewModel.booking.StudentManageBookingViewModel;

public class StudentManageBookingController {

    @FXML
    private ListView<Booking> bookingList;

    private StudentManageBookingViewModel studentManageBookingViewModel;
    private ViewHandler viewHandler;

    public void init( ViewHandler viewHandler,StudentManageBookingViewModel studentManageBookingViewModel) {
        this.studentManageBookingViewModel= studentManageBookingViewModel;
        this.viewHandler=viewHandler;
    }
    public void getMyBooking(){
        bookingList.setItems(studentManageBookingViewModel.getBookingsObList());
    }
    public void cancelBooking(){
       studentManageBookingViewModel.cancelBooking(bookingList.getSelectionModel().getSelectedItem());
       getMyBooking();
    }
}
