package view.booking.student;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import view.ViewHandler;
import view.booking.student.booking.StudentBookingController;
import view.booking.student.managebooking.StudentManageBookingController;
import viewModel.ViewModelFactory;

public class StudentTabViewController {
    private ViewHandler viewHandler;
    private ViewModelFactory vm;
    @FXML
    public TabPane tabPane;
    @FXML
    private StudentBookingController studentBookingController;
    @FXML
    private StudentManageBookingController studentManageBookingController;

    public void init(ViewHandler viewHandler, ViewModelFactory vm) {
        this.viewHandler = viewHandler;
        this.vm = vm;
        studentBookingController.init(viewHandler,vm.getStudentBookingViewModel());
        studentManageBookingController.init(viewHandler,vm.getStudentManageBookingViewModel());
    }

    public void logOut(){
        viewHandler.getCurrentUser().setCurrentUser(null);
        viewHandler.openLogin();
    }
}
