package view.booking.teacher.booking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import room_model.Room;
import view.ViewHandler;
import viewModel.booking.TeacherBookingViewModel;

import java.time.LocalDate;
import java.util.Date;

public class TeacherBookingController {
    private TeacherBookingViewModel viewModel;
    private ViewHandler viewHandler;

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


    public void init(ViewHandler viewHandler,TeacherBookingViewModel viewModel){
        this.viewHandler=viewHandler;
        this.viewModel = viewModel;
        bookingDate.setValue(LocalDate.now());
        date = new Date(bookingDate.getValue().getYear(),bookingDate.getValue().getMonthValue(),bookingDate.getValue().getDayOfMonth());
        bookingDate.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0 );
            }
        });
        bookingDate.valueProperty().addListener((observable ,oldValue,newValue)-> {
            date = new Date( newValue.getYear(),newValue.getMonthValue(),newValue.getDayOfMonth());
        });
        viewModel.bindStartTime(startTime.textProperty());
        viewModel.bindEndTime(endTime.textProperty());
        viewModel.bindError(error.textProperty());
    }
    public void book(ActionEvent actionEvent){
        viewModel.bookRoom(roomsList.getSelectionModel().getSelectedItem().getRoomId());
        bookingDate.setValue(LocalDate.now());

    }
    public void getAvailableRooms(ActionEvent actionEvent){
        roomsList.setItems(viewModel.getAvailableRooms(date));
    }
}
