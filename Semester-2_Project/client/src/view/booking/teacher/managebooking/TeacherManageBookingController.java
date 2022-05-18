package view.booking.teacher.managebooking;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import view.ViewHandler;
import viewModel.booking.StudentManageBookingViewModel;
import viewModel.booking.TeacherBookingViewModel;
import viewModel.booking.TeacherManageBookingViewModel;

public class TeacherManageBookingController {

    public ListView bookingList;
    private TeacherManageBookingViewModel viewModel;
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler,TeacherManageBookingViewModel viewModel){
        this.viewModel=viewModel;
        this.viewHandler=viewHandler;


    }

    public void cancelBooking(ActionEvent actionEvent) {
        System.out.println("Cancel");
    }
}
