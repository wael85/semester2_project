package view.addUser.student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import viewModel.ViewModelFactory;
import viewModel.administrator.AddStudentViewModel;

public class AddStudentController {

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
    public Label error;
    private AddStudentViewModel addStudentViewModel;
    private ViewModelFactory viewModelFactory;

    public void init(AddStudentViewModel addStudentViewModel) {

        this.addStudentViewModel=addStudentViewModel;
        addStudentViewModel.bindStudentNumber(studentNumber.textProperty());
        addStudentViewModel.bindFirstName(firstName.textProperty());
        addStudentViewModel.bindLastName(lastName.textProperty());
        addStudentViewModel.bindPhone(phone.textProperty());
        addStudentViewModel.bindEmail(email.textProperty());
        addStudentViewModel.bindError(error.textProperty());

    }
    @FXML
    public void AddStudent(ActionEvent actionEvent) {
        addStudentViewModel.createStudent();
        studentNumber.clear(); firstName.clear();lastName.clear();phone.clear();email.clear();password.clear();
    }
    @FXML
    public void Cancel(ActionEvent actionEvent) {
    }


}
