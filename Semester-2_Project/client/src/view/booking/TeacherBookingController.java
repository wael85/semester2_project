package view.booking;

import view.ViewHandler;

public class TeacherBookingController {
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler){
        this.viewHandler = viewHandler;
    }
    public void logout(){
        viewHandler.getCurrentUser().setCurrentUser(null);
        viewHandler.openLogin();
    }
}
