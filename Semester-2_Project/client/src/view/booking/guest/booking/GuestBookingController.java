package view.booking.guest.booking;

import view.ViewHandler;

public class GuestBookingController {
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler){
        this.viewHandler = viewHandler;
    }
    public void logout(){
        viewHandler.getCurrentUser().setCurrentUser(null);
        viewHandler.openLogin();
    }
}
