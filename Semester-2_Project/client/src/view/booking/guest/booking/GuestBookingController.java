package view.booking.guest.booking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.inputValidation.ValidatorBooking;
import room_model.Room;
import view.ViewHandler;
import viewModel.booking.GuestBookingViewModel;

import java.time.LocalDate;
import java.util.Date;

public class GuestBookingController {
    private ViewHandler viewHandler;

    private GuestBookingViewModel guestBookingViewModel;
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

    public void init(ViewHandler viewHandler,GuestBookingViewModel guestBookingViewModel){
        this.viewHandler=viewHandler;
        this.guestBookingViewModel = guestBookingViewModel;
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
        this.guestBookingViewModel.bindStartTime(startTime.textProperty());
        this.guestBookingViewModel.bindEndTime(endTime.textProperty());
        this.guestBookingViewModel.bindError(error.textProperty());
    }
    public void book(ActionEvent actionEvent){
        if (roomsList.getSelectionModel().getSelectedItem()!=null){
            guestBookingViewModel.bookRoom(roomsList.getSelectionModel().getSelectedItem().getRoomId());
            bookingDate.setValue(LocalDate.now());
        }else{
            ValidatorBooking.notificationPopup("Please select an available room!");
        }


    }
    public void getAvailableRooms(ActionEvent actionEvent){
        roomsList.setItems(guestBookingViewModel.getAvailableRooms(date));
    }
}
