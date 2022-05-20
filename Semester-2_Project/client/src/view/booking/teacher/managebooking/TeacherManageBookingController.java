package view.booking.teacher.managebooking;

import booking.Booking;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import view.ViewHandler;
import viewModel.booking.StudentManageBookingViewModel;
import viewModel.booking.TeacherBookingViewModel;
import viewModel.booking.TeacherManageBookingViewModel;

public class TeacherManageBookingController {
    @FXML
    public ListView<Booking> bookingList;
    private TeacherManageBookingViewModel viewModel;
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler,TeacherManageBookingViewModel viewModel){
        this.viewModel=viewModel;
        this.viewHandler=viewHandler;


    }
    public void getMyBooking(){
        bookingList.setItems(viewModel.getBookingsObList());
    }
    public void cancelBooking(ActionEvent actionEvent) {
        viewModel.cancelBooking(bookingList.getSelectionModel().getSelectedItem());
        getMyBooking();
    }
}
