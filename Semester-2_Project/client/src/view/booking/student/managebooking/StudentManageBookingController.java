package view.booking.student.managebooking;

import booking.Booking;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import view.ViewHandler;
import viewModel.booking.StudentManageBookingViewModel;

import javax.swing.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
        Timestamp t = new Timestamp(LocalDateTime.now().getYear()-1900,LocalDateTime.now().getMonthValue()-1,LocalDateTime.now().getDayOfMonth(),LocalDateTime.now().getHour(),LocalDateTime.now().getMinute(),0,0);
        if(bookingList.getSelectionModel().getSelectedItem().getStartDateTime().getTime() > t.getTime()){
            JOptionPane.showMessageDialog( null ,"It is not time yet for check in");
        }else {
            studentManageBookingViewModel.checkIn(bookingList.getSelectionModel().getSelectedItem());
        }
    }
}
