package view.manageUser.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import users_model.User;
import viewModel.manageUsers.ManageAdminViewModel;


public class ManageAdminController {
    @FXML
    public TextField firstname;
    @FXML
    public TextField lastname;
    @FXML
    public TextField adminId;
    @FXML
    public TextField phone;
    @FXML
    public TextField email;
    @FXML
    public PasswordField password;
    @FXML
    public ListView<User> list;

    private ManageAdminViewModel manageAdminViewModel;


    public void init(ManageAdminViewModel manageAdminViewModel) {

        this.manageAdminViewModel = manageAdminViewModel;
        list.setItems(manageAdminViewModel.getUserObservableList());

        manageAdminViewModel.bindAdminId(adminId.textProperty());
        manageAdminViewModel.bindFirstName(firstname.textProperty());
        manageAdminViewModel.bindLastName(lastname.textProperty());
        manageAdminViewModel.bindPhone(phone.textProperty());
        manageAdminViewModel.bindEmail(email.textProperty());
        manageAdminViewModel.bindPassword(password.textProperty());
    }

    public String getUserName(){
        return list.getSelectionModel().getSelectedItem().getUserName();
    }

    @FXML
    public void addAdmin() {
        manageAdminViewModel.createAdmin();
    }

    public void deleteButton(ActionEvent actionEvent) {
        manageAdminViewModel.deleteUser(getUserName());
    }
}
