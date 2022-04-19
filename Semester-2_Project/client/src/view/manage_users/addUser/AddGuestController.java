package view.manage_users.addUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import viewModel.administrator.AddGuestViewModel;

public class AddGuestController {
    @FXML
    public TextField companyName;
    @FXML
    public TextField CVR;
    @FXML
    public TextField phone;
    @FXML
    public TextField email;
    @FXML
    public PasswordField password;
    @FXML
    public Label error;

    private AddGuestViewModel addGuestViewModel;

    public void init(AddGuestViewModel addGuestViewModel) {
        this.addGuestViewModel=addGuestViewModel;
        addGuestViewModel.bindCompanyName(companyName.textProperty());
        addGuestViewModel.bindCVR(CVR.textProperty());
        addGuestViewModel.bindPhone(phone.textProperty());
        addGuestViewModel.bindEmail(email.textProperty());
        addGuestViewModel.bindPassword(password.textProperty());
        addGuestViewModel.bindError(error.textProperty());
    }

    @FXML
    public void AddGuest(ActionEvent actionEvent) {
        addGuestViewModel.createGuest();
    }

    @FXML
    public void Cancel(ActionEvent actionEvent) {
    }




}
