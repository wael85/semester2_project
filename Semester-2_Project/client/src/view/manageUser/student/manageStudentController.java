package view.manageUser.student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import viewModel.ViewModelFactory;
import viewModel.administrator.ManageStudentViewModel;

public class manageStudentController {

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
    @FXML

    private ManageStudentViewModel manageStudentViewModel;
    private ViewModelFactory viewModelFactory;

    public void init(ManageStudentViewModel manageStudentViewModel) {

        this.manageStudentViewModel = manageStudentViewModel;
        manageStudentViewModel.bindStudentNumber(studentNumber.textProperty());
        manageStudentViewModel.bindFirstName(firstName.textProperty());
        manageStudentViewModel.bindLastName(lastName.textProperty());
        manageStudentViewModel.bindPhone(phone.textProperty());
        manageStudentViewModel.bindEmail(email.textProperty());


    }
    @FXML
    public void AddStudent(ActionEvent actionEvent) {
        manageStudentViewModel.createStudent();
        studentNumber.clear(); firstName.clear();lastName.clear();phone.clear();email.clear();password.clear();
    }
    @FXML
    public void Cancel(ActionEvent actionEvent) {
    }


    public void selectedStudent(MouseEvent mouseEvent) {
    }

    public void searchStudent(ActionEvent actionEvent) {
    }

    public void deleteButton(ActionEvent actionEvent) {
    }
}
