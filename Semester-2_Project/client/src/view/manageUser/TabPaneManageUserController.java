package view.manageUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import view.ViewHandler;
import view.manageUser.admin.ManageAdminController;
import view.manageUser.guest.ManageGuestController;
import view.manageUser.student.ManageStudentController;
import view.manageUser.teacher.ManageTeacherController;
import viewModel.ViewModelFactory;

public class TabPaneManageUserController {

    private ViewHandler viewHandler;

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

    public void init(ViewModelFactory viewModelFactory,ViewHandler viewHandler){
        this.viewHandler=viewHandler;
        this.viewModelFactory=viewModelFactory;
        manageAdminController.init(viewModelFactory.getManageAdminViewModel());
        manageTeacherController.init(viewModelFactory.getManageTeacherViewModel());
        manageStudentController.init(viewModelFactory.getManageStudentViewModel());
        manageGuestController.init(viewModelFactory.getManagGuestViewModel());
    }

    public void backToMain(ActionEvent actionEvent) {
        viewHandler.openMainMenu();
    }
}
