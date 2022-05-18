package view.booking.student.booking;

import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import room_model.Room;
import view.ViewHandler;
import viewModel.booking.StudentBookingViewModel;

import java.sql.Timestamp;
import java.util.Date;

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
    @FXML
    private Label error;
    private Date date;

    public void init(ViewHandler viewHandler,StudentBookingViewModel studentBookingViewModel){
        this.viewHandler=viewHandler;
        this.studentBookingViewModel = studentBookingViewModel;

        bookingDate.valueProperty().addListener((observable ,oldValue,newValue)-> {
            date = new Date( newValue.getYear(),newValue.getMonthValue(),newValue.getDayOfMonth());
        });
        studentBookingViewModel.bindStartTime(startTime.textProperty());
        studentBookingViewModel.bindEndTime(endTime.textProperty());
        studentBookingViewModel.bindError(error.textProperty());
    }
    public void book(ActionEvent actionEvent){
      studentBookingViewModel.bookRoom(roomsList.getSelectionModel().getSelectedItem().getRoomId());
    }
    public void getAvailableRooms(ActionEvent actionEvent){
        roomsList.setItems(studentBookingViewModel.getAvailableRooms(date));
    }
}
