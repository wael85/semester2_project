package view.booking.guest.booking;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import view.ViewHandler;
import viewModel.booking.GuestBookingViewModel;

public class GuestBookingController {
    public ListView roomsList;
    public DatePicker bookingDate;
    public TextField startTime;
    public TextField endTime;
    private ViewHandler viewHandler;
    private GuestBookingViewModel viewModel;
    private TextField date;

    public void init(ViewHandler viewHandler, GuestBookingViewModel viewModel){
        this.viewModel=viewModel;
        this.viewHandler = viewHandler;
        bookingDate.valueProperty().addListener((observable ,oldValue,newValue)-> {
            date.textProperty().set(newValue.toString());
        });
        viewModel.bindDate(date.textProperty());
        viewModel.bindStartTime(startTime.textProperty());
        viewModel.bindEndTime(endTime.textProperty());
    }
    public void logout(){
        viewHandler.getCurrentUser().setCurrentUser(null);
        viewHandler.openLogin();
    }

    public void getAvailableRooms(ActionEvent actionEvent) {
        roomsList.setItems(viewModel.getAvailableRooms());
    }

    public void book(ActionEvent actionEvent) {
        System.out.println("Booking");
    }
}
