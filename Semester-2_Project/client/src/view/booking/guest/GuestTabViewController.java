package view.booking.guest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.ViewHandler;
import view.booking.guest.booking.GuestBookingController;
import view.booking.guest.managebooking.GuestManageBookingController;
import view.booking.teacher.booking.TeacherBookingController;
import view.booking.teacher.managebooking.TeacherManageBookingController;
import viewModel.ViewModelFactory;

public class GuestTabViewController {


    private ViewHandler viewHandler;
    private ViewModelFactory vmf;

    @FXML
    private GuestBookingController guestBookingController;
    @FXML
    private GuestManageBookingController guestManageBookingController;

    public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
        this.viewHandler =viewHandler;
        this.vmf = vmf;
        this.guestBookingController.init(viewHandler,vmf.getGuestBookingViewModel());
        this.guestManageBookingController.init(viewHandler,vmf.getGuestManageBookingViewModel());
    }

    public void logOut() {
        viewHandler.getCurrentUser().setCurrentUser(null);
        viewHandler.openLogin();
    }

}
