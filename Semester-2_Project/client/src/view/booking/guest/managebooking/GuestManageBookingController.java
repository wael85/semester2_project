package view.booking.guest.managebooking;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import view.ViewHandler;
import viewModel.booking.GuestManageBookingViewModel;

public class GuestManageBookingController {
    public ListView bookingList;
    private ViewHandler viewHandler;
    private GuestManageBookingViewModel viewModel;

    public void init(ViewHandler viewHandler,GuestManageBookingViewModel viewModel){
        this.viewHandler=viewHandler;
        this.viewModel=viewModel;

    }

    public void cancelBooking(ActionEvent actionEvent) {

    }
}
