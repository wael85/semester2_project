package viewModel.manageUsers;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import users_model.User;
import users_model.Users;
import model.users_mangment.UsersManagementModel;
import model.inputValidation.ValidatorManageUsers;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;

public class ManageStudentViewModel {
    private UsersManagementModel usersManagementModel;
    private StringProperty firstname;
    private StringProperty lastname;
    private StringProperty studentNumber;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;
    private StringProperty error;
    private ObservableList<User> userObservableList;

    public ManageStudentViewModel(UsersManagementModel model) {
        this.usersManagementModel = model;
        userObservableList = FXCollections.observableArrayList();
        usersManagementModel.addPropertyChangeListener("users", evt -> {
            updateUsersList(evt);
        });
        firstname = new SimpleStringProperty("");
        lastname = new SimpleStringProperty("");
        studentNumber = new SimpleStringProperty("");
        phone = new SimpleStringProperty("");
        email = new SimpleStringProperty("");
        password = new SimpleStringProperty("");
        error = new SimpleStringProperty("");

    }

    public void bindFirstName(StringProperty property) {
        property.bindBidirectional(firstname);
    }

    public void bindLastName(StringProperty property) {
        property.bindBidirectional(lastname);
    }

    public void bindStudentNumber(StringProperty property) {
        property.bindBidirectional(studentNumber);
    }

    public void bindEmail(StringProperty property) {
        property.bindBidirectional(email);
    }

    public void bindPhone(StringProperty property) {
        property.bindBidirectional(phone);
    }

    public void bindPassword(StringProperty property) {
        property.bindBidirectional(password);
    }

    public void bindError(StringProperty property) {

        property.bind(error);
    }

    public void createStudent() {
        try {

            usersManagementModel.createStudent(studentNumber.get(), password.get(), firstname.get(), lastname.get(), email.get(), phone.get());
            notification(studentNumber.getValue() + ", add successfully");
            clearFields();
        } catch (Exception e) {
            if(e.getMessage().contains("duplicate key value")){
                notification("User already existed");
            }else
            notification(e.getMessage());
        }
    }

    public void notification(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public void updateUsersList(PropertyChangeEvent e) {
        Platform.runLater(() -> {
            userObservableList.clear();
            userObservableList.addAll(((Users) e.getNewValue()).getStudents());
        });
    }

    public ObservableList<User> getUserObservableList() {
        userObservableList.clear();
        try {
            userObservableList.addAll(usersManagementModel.getAllUsers().getStudents());
            error.set("");
        } catch (RemoteException e) {
            error.set(e.getMessage());
            e.getStackTrace();
        }
        return userObservableList;
    }
    public void deleteUser(String userName) {
        try {
            usersManagementModel.deleteUser(userName);
        } catch (RemoteException ex) {
            error.set(ex.getMessage());
        }
    }
    public void clearFields(){
        firstname.set("");
        lastname.set("");
        studentNumber.set("");
        phone.set("");
        email.set("");
        password.set("");
    }
}
