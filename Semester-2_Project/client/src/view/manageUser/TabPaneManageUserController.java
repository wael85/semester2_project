package view.manageUser;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import view.manageUser.admin.ManageAdminController;
import view.manageUser.guest.ManageGuestController;
import view.manageUser.student.ManageStudentController;
import view.manageUser.teacher.ManageTeacherController;
import viewModel.ViewModelFactory;

public class TabPaneManageUserController {
    @FXML
    public TabPane tabPane;

    @FXML
    private ManageAdminController manageAdminController;
    @FXML
    private ManageTeacherController manageTeacherController;
    @FXML
    private ManageStudentController manageStudentController;
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
