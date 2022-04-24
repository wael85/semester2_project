package view.manageUser;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import view.manageUser.admin.manageAdminController;
import view.manageUser.guest.ManageGuestController;
import view.manageUser.student.manageStudentController;
import view.manageUser.teacher.ManageTeacherController;
import viewModel.ViewModelFactory;

public class TabPaneManageUserController {
    @FXML
    public TabPane tabPane;

    @FXML
    private manageAdminController manageAdminController;
    @FXML
    private ManageTeacherController manageTeacherController;
    @FXML
    private manageStudentController manageStudentController;
    @FXML
    private ManageGuestController manageGuestController;

    private ViewModelFactory viewModelFactory;

    public void init(ViewModelFactory viewModelFactory){
        this.viewModelFactory=viewModelFactory;

        manageAdminController.init(viewModelFactory.getManageAdminViewModel());
        manageTeacherController.init(viewModelFactory.getManageTeacherViewModel());
        manageStudentController.init(viewModelFactory.getManageStudentViewModel());
        manageGuestController.init(viewModelFactory.getManagGuestViewModel());

    }
}
