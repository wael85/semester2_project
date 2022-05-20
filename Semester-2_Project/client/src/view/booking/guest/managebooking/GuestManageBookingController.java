package view.booking.guest.managebooking;

import booking.Booking;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import view.ViewHandler;
import viewModel.booking.GuestManageBookingViewModel;

public class GuestManageBookingController {
    public ListView<Booking> bookingList;
    private ViewHandler viewHandler;
    private GuestManageBookingViewModel viewModel;

    public void init(ViewHandler viewHandler,GuestManageBookingViewModel viewModel){
        this.viewHandler=viewHandler;
        this.viewModel=viewModel;

    }
    public void getMyBooking(){
        bookingList.setItems(viewModel.getBookingsObList());
    }
    public void cancelBooking(){
        viewModel.cancelBooking(bookingList.getSelectionModel().getSelectedItem());
        getMyBooking();
    }
}
