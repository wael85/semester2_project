package view.manageUser.teacher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import viewModel.administrator.ManageTeacherViewModel;


public class ManageTeacherController {
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

    private ManageTeacherViewModel manageTeacherViewModel;


    public void init(ManageTeacherViewModel manageTeacherViewModel) {
        this.manageTeacherViewModel = manageTeacherViewModel;
        manageTeacherViewModel.bindStaffId(staffId.textProperty());
        manageTeacherViewModel.bindFirstName(firstName.textProperty());
        manageTeacherViewModel.bindLastName(lastname.textProperty());
        manageTeacherViewModel.bindPhone(phone.textProperty());
        manageTeacherViewModel.bindEmail(email.textProperty());
        manageTeacherViewModel.bindPassword(password.textProperty());


    }
    @FXML
    public void Cancel(ActionEvent actionEvent) {
    }


    @FXML
    public void addTeacher(ActionEvent actionEvent) {
        manageTeacherViewModel.createTeacher();
        staffId.clear();firstName.clear(); lastname.clear();phone.clear();email.clear();password.clear();
    }


    public void searchTeacher(ActionEvent actionEvent) {
    }

    public void selectedTeacher(MouseEvent mouseEvent) {
    }

    public void deleteButton(ActionEvent actionEvent) {
    }
}
