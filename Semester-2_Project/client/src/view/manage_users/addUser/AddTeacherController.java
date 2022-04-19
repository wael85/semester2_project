package view.manage_users.addUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import viewModel.administrator.AddTeacherViewModel;

public class AddTeacherController {
    @FXML
    public TextField firstName;
    @FXML
    public TextField lastname;
    @FXML
    public TextField staffId;
    @FXML
    public TextField phone;
    @FXML
    public TextField email;
    @FXML
    public PasswordField password;
    @FXML
    public Label error;
    private AddTeacherViewModel addTeacherViewModel;


    public void init(AddTeacherViewModel addTeacherViewModel) {
        this.addTeacherViewModel=addTeacherViewModel;
        addTeacherViewModel.bindStaffId(staffId.textProperty());
        addTeacherViewModel.bindFirstName(firstName.textProperty());
        addTeacherViewModel.bindLastName(lastname.textProperty());
        addTeacherViewModel.bindPhone(phone.textProperty());
        addTeacherViewModel.bindEmail(email.textProperty());
        addTeacherViewModel.bindPassword(password.textProperty());
        addTeacherViewModel.bindError(error.textProperty());

    }
    @FXML
    public void Cancel(ActionEvent actionEvent) {
    }


    @FXML
    public void addTeacher(ActionEvent actionEvent) {
        addTeacherViewModel.createTeacher();
    }
}
