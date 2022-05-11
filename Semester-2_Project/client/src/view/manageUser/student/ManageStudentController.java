package view.manageUser.student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import users_model.User;
import viewModel.ViewModelFactory;
import viewModel.manageUsers.ManageStudentViewModel;

public class ManageStudentController {

    @FXML
    public TextField lastName;
    @FXML
    public TextField firstName;
    @FXML
    public TextField studentNumber;
    @FXML
    public TextField phone;
    @FXML
    public TextField email;
    @FXML
    public PasswordField password;
    public ListView<User> list;
    @FXML

    private ManageStudentViewModel manageStudentViewModel;
    private ViewModelFactory viewModelFactory;

    public void init(ManageStudentViewModel manageStudentViewModel) {

        this.manageStudentViewModel = manageStudentViewModel;
        list.setItems(manageStudentViewModel.getUserObservableList());
        manageStudentViewModel.bindStudentNumber(studentNumber.textProperty());
        manageStudentViewModel.bindFirstName(firstName.textProperty());
        manageStudentViewModel.bindLastName(lastName.textProperty());
        manageStudentViewModel.bindPhone(phone.textProperty());
        manageStudentViewModel.bindEmail(email.textProperty());
        manageStudentViewModel.bindPassword(password.textProperty());
    }

    @FXML
    public void AddStudent(ActionEvent actionEvent) {
        manageStudentViewModel.createStudent();

    }

    @FXML
    public void Cancel(ActionEvent actionEvent) {
    }

    public String getUserName() {
        return list.getSelectionModel().getSelectedItem().getUserName();
    }


    public void selectedStudent(MouseEvent mouseEvent) {
    }

    public void searchStudent(ActionEvent actionEvent) {
    }

    public void deleteButton(ActionEvent actionEvent) {
    manageStudentViewModel.deleteUser(getUserName());
    }
}
