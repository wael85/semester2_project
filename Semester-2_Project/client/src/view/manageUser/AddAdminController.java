package view.manageUser;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import view.ViewHandler;
import viewModel.AddAdminViewModel;

public class AddAdminController {
    public TextField firstname;
    public TextField lastname;
    public TextField AdminId;
    public TextField phone;
    public TextField email;
    public PasswordField password;
    private Region root;
    private ViewHandler viewHandler;
    AddAdminViewModel addAdminViewModel;

    public void AddAdmin(ActionEvent actionEvent) {

    }

    public void Cancel(ActionEvent actionEvent) {
    }

    public void goAddStudent(ActionEvent actionEvent) {
    }

    public void goAddGuest(ActionEvent actionEvent) {
    }

    public void goAddTeacher(ActionEvent actionEvent) {
    }

    public void goAddAdmin(ActionEvent actionEvent) {
    }

    public void init(ViewHandler viewHandler, AddAdminViewModel addAdminViewModel, Region root) {
        this.viewHandler= viewHandler;
        this.addAdminViewModel=addAdminViewModel;
        this.root= root;

    }

    public Region getRoot() {
        return root;
    }
}
