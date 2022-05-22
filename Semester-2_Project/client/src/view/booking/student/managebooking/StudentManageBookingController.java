package view.booking.student.managebooking;

import booking.Booking;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import view.ViewHandler;
import viewModel.booking.StudentManageBookingViewModel;

public class StudentManageBookingController {

    @FXML
    private ListView<Booking> bookingList;
    @FXML
    private Label error;
    private StudentManageBookingViewModel studentManageBookingViewModel;
    private ViewHandler viewHandler;

    public void init( ViewHandler viewHandler,StudentManageBookingViewModel studentManageBookingViewModel) {
        this.studentManageBookingViewModel= studentManageBookingViewModel;
        this.viewHandler=viewHandler;
        studentManageBookingViewModel.bindError(error.textProperty());
    }
    public void getMyBooking(){
        bookingList.setItems(studentManageBookingViewModel.getBookingsObList());
    }
    public void cancelBooking(){
       studentManageBookingViewModel.cancelBooking(bookingList.getSelectionModel().getSelectedItem());
       getMyBooking();
    }
    public void checkIn(){
        studentManageBookingViewModel.checkIn(bookingList.getSelectionModel().getSelectedItem());
    }
}
