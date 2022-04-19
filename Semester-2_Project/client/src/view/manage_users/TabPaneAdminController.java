package view.manage_users;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import view.manage_users.addUser.AddAdminController;
import view.manage_users.addUser.AddGuestController;
import view.manage_users.addUser.AddStudentController;
import view.manage_users.addUser.AddTeacherController;
import viewModel.ViewModelFactory;

public class TabPaneAdminController {
    @FXML
    private Tab tab1;
    @FXML
    private Tab tab2;
    @FXML
    private Tab tab3;
    @FXML
    private Tab tab4;
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
