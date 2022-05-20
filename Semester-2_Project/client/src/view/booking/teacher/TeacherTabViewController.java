package view.booking.teacher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import view.ViewHandler;
import view.booking.teacher.booking.TeacherBookingController;
import view.booking.teacher.managebooking.TeacherManageBookingController;
import viewModel.ViewModelFactory;

public class TeacherTabViewController {


    private ViewHandler viewHandler;
    private ViewModelFactory vmf;
    @FXML
    private TeacherBookingController teacherBookingController;
    @FXML
    private TeacherManageBookingController teacherManageBookingController;

    public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
        this.viewHandler =viewHandler;
        this.vmf = vmf;
        teacherBookingController.init(viewHandler,vmf.getTeacherBookingViewModel());
        teacherManageBookingController.init(viewHandler,vmf.getTeacherManageBookingViewModel());

    }

    public void logOut() {
        viewHandler.getCurrentUser().setCurrentUser(null);
        viewHandler.openLogin();
    }
}
