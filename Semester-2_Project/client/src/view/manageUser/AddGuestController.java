package view.manageUser;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import view.ViewHandler;
import viewModel.AddGuestViewModel;

public class AddGuestController {
    public TextField name;
    public TextField CVR;
    public TextField phone;
    public TextField email;
    public PasswordField password;
    private Region root;
    private ViewHandler viewHandler;


    public void AddGuest(ActionEvent actionEvent) {
    }

    public void cancel(ActionEvent actionEvent) {
    }


    public void goAddStudent(ActionEvent actionEvent) {
    }

    public void goAddGuest(ActionEvent actionEvent) {
    }

    public void goAddTeacher(ActionEvent actionEvent) {
    }

    public void goAddAdmin(ActionEvent actionEvent) {
    }

    public void Cancel(ActionEvent actionEvent) {
    }


    public void init(ViewHandler viewHandler, AddGuestViewModel addGuestViewModel, Region root) {
    }

    public Region getRoot() {
        return root;
    }
}
