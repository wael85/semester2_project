package view.addUser;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import view.addUser.admin.AddAdminController;
import view.addUser.guest.AddGuestController;
import view.addUser.student.AddStudentController;
import view.addUser.teacher.AddTeacherController;
import viewModel.ViewModelFactory;

public class TabPaneAdminController {
    @FXML
    public TabPane tabPane;

    @FXML
    private AddAdminController addAdminController;
    @FXML
    private AddTeacherController addTeacherController;
    @FXML
    private AddStudentController addStudentController;
    @FXML
    private AddGuestController addGuestController;

    private ViewModelFactory viewModelFactory;

    public void init(ViewModelFactory viewModelFactory){
        this.viewModelFactory=viewModelFactory;

        addAdminController.init(viewModelFactory.getAddAdminViewModel());
        addTeacherController.init(viewModelFactory.getAddTeacherViewModel());
        addStudentController.init(viewModelFactory.getAddStudentViewModel());
        addGuestController.init(viewModelFactory.getAddGuestViewModel());

    }
}
