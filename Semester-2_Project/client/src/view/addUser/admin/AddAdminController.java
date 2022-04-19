package view.addUser.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import viewModel.ViewModelFactory;
import viewModel.administrator.AddAdminViewModel;

public class AddAdminController {
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
    public Label error;
    private AddAdminViewModel addAdminViewModel;


    public void init(AddAdminViewModel addAdminViewModel) {

        this.addAdminViewModel = addAdminViewModel;

        addAdminViewModel.bindAdminId(adminId.textProperty());
        addAdminViewModel.bindFirstName(firstname.textProperty());
        addAdminViewModel.bindLastName(lastname.textProperty());
        addAdminViewModel.bindPhone(phone.textProperty());
        addAdminViewModel.bindEmail(email.textProperty());
        addAdminViewModel.bindPassword(password.textProperty());
        addAdminViewModel.bindError(error.textProperty());

    }


    @FXML
    public void addAdmin() {
        addAdminViewModel.createAdmin();
        adminId.clear(); firstname.clear(); lastname.clear(); phone.clear(); email.clear(); password.clear();

    }

    @FXML
    public void selectView() {

    }

    @FXML
    public void cancel(ActionEvent actionEvent) {
    }
}
