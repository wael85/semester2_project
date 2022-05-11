package view.manageUser.teacher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import users_model.User;
import viewModel.manageUsers.ManageTeacherViewModel;


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
    public ListView<User> list;

    private ManageTeacherViewModel manageTeacherViewModel;


    public void init(ManageTeacherViewModel manageTeacherViewModel) {
        this.manageTeacherViewModel = manageTeacherViewModel;
        list.setItems(manageTeacherViewModel.getUserObservableList());
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

    public String getUserName() {
        return list.getSelectionModel().getSelectedItem().getUserName();
    }

    @FXML
    public void addTeacher() {
        manageTeacherViewModel.createTeacher();

    }


    public void searchTeacher(ActionEvent actionEvent) {
    }

    public void selectedTeacher(MouseEvent mouseEvent) {
    }

    public void deleteButton(ActionEvent actionEvent) {
        manageTeacherViewModel.deleteUser(getUserName());
    }
}
