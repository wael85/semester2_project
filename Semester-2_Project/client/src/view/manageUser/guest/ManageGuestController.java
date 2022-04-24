package view.manageUser.guest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import viewModel.administrator.ManageGuestViewModel;


public class ManageGuestController {
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

    private ManageGuestViewModel addGuestViewModel;

    public void init(ManageGuestViewModel manageGuestViewModel) {
        this.addGuestViewModel = manageGuestViewModel;
        manageGuestViewModel.bindCompanyName(companyName.textProperty());
        manageGuestViewModel.bindCVR(CVR.textProperty());
        manageGuestViewModel.bindPhone(phone.textProperty());
        manageGuestViewModel.bindEmail(email.textProperty());
        manageGuestViewModel.bindPassword(password.textProperty());

    }

    @FXML
    public void AddGuest(ActionEvent actionEvent) {
        addGuestViewModel.createGuest();
        companyName.clear(); CVR.clear(); phone.clear(); email.clear();password.clear();
    }




    public void selectedGuest(MouseEvent mouseEvent) {
    }


    public void deleteButton(ActionEvent actionEvent) {
    }
}
