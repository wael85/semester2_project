package view.booking.student.booking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import room_model.Room;
import view.ViewHandler;
import viewModel.booking.StudentBookingViewModel;

public class StudentBookingController {
    private ViewHandler viewHandler;
    private StudentBookingViewModel studentBookingViewModel;
    @FXML
    private ListView<Room> roomsList;
    @FXML
    private DatePicker bookingDate;
    @FXML
    private TextField startTime;
    @FXML
    private TextField endTime;

    public void init(ViewHandler viewHandler, StudentBookingViewModel studentBookingViewModel){
        this.viewHandler = viewHandler;
        this.studentBookingViewModel = studentBookingViewModel;
    }
    public void book(ActionEvent actionEvent){
        System.out.println("booking");
    }
    public void logout(ActionEvent actionEvent){
        viewHandler.getCurrentUser().setCurrentUser(null);
        viewHandler.openLogin();
    }
}
