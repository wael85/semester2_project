package view.manageUser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import view.ViewHandler;
import viewModel.AddAdminViewModel;

public class AddAdminController {
   @FXML public TextField firstname;
    @FXML public TextField lastname;
    @FXML public TextField adminId;
    @FXML public TextField phone;
    @FXML public TextField email;
    @FXML public PasswordField password;
    @FXML public Label error;
    private Region root;
    private ViewHandler viewHandler;
    AddAdminViewModel addAdminViewModel;


    public void init(ViewHandler viewHandler, AddAdminViewModel addAdminViewModel, Region root) {
        this.viewHandler= viewHandler;
        this.addAdminViewModel=addAdminViewModel;
        this.root= root;
        addAdminViewModel.bindAdminId(adminId.textProperty());
        addAdminViewModel.bindFirstName(firstname.textProperty());
        addAdminViewModel.bindLastName(lastname.textProperty());
        addAdminViewModel.bindPhone(phone.textProperty());
        addAdminViewModel.bindEmail(email.textProperty());
        addAdminViewModel.bindPassword(password.textProperty());
        addAdminViewModel.bindError(error.textProperty());


    }

    public Region getRoot() {
        return root;
    }

    @FXML
    public void addAdmin() {
        addAdminViewModel.createAdmin();
    }
    @FXML
    public void selectView(){

    }
    @FXML
    public void cancel(ActionEvent actionEvent) {
    }
    public void goAddStudent(ActionEvent actionEvent) {
        viewHandler.openView("addStudent");
    }

    public void goAddGuest(ActionEvent actionEvent) {
        viewHandler.openView("addGuest");
    }

    public void goAddTeacher(ActionEvent actionEvent) {
        viewHandler.openView("addTeacher");
    }

    public void goAddAdmin(ActionEvent actionEvent) {
        viewHandler.openView("addAdmin");
    }
}
