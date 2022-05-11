package view.manageUser.guest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import users_model.User;
import viewModel.manageUsers.ManageGuestViewModel;


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
    public ListView<User> list;

    private ManageGuestViewModel addGuestViewModel;

    public void init(ManageGuestViewModel manageGuestViewModel) {
        this.addGuestViewModel = manageGuestViewModel;
        list.setItems(manageGuestViewModel.getUserObservableList());
        manageGuestViewModel.bindCompanyName(companyName.textProperty());
        manageGuestViewModel.bindCVR(CVR.textProperty());
        manageGuestViewModel.bindPhone(phone.textProperty());
        manageGuestViewModel.bindEmail(email.textProperty());
        manageGuestViewModel.bindPassword(password.textProperty());

    }

    @FXML
    public void AddGuest() {
        addGuestViewModel.createGuest();

    }

    public String getUserName() {
        return list.getSelectionModel().getSelectedItem().getUserName();
    }


    public void selectedGuest(MouseEvent mouseEvent) {
    }


    public void deleteButton(ActionEvent actionEvent) {
        addGuestViewModel.deleteGuest(getUserName());
    }
}
