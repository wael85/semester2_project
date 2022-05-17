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

public class ManageGuestViewModel {
    private UsersManagementModel usersManagementModel;
    private StringProperty companyName;
    private StringProperty CVR;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;
    private StringProperty error;
    private ObservableList<User> userObservableList;

    public ManageGuestViewModel(UsersManagementModel model) {
        this.usersManagementModel = model;
        userObservableList = FXCollections.observableArrayList();
        usersManagementModel.addPropertyChangeListener("users", evt -> {
            updateUsersList(evt);
        });
        companyName = new SimpleStringProperty("");
        CVR = new SimpleStringProperty("");
        phone = new SimpleStringProperty("");
        email = new SimpleStringProperty("");
        password = new SimpleStringProperty("");
        error = new SimpleStringProperty("");

    }

    public void bindCompanyName(StringProperty property) {
        property.bindBidirectional(companyName);
    }

    public void bindCVR(StringProperty property) {
        property.bindBidirectional(CVR);
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

    public void createGuest() {
        try {

            usersManagementModel.createGuest(CVR.get(), password.get(), companyName.get(), email.get(), phone.get());
            notification(CVR.getValue() + ", add successfully");
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
            userObservableList.addAll(((Users) e.getNewValue()).getGuests());
        });
    }

    public ObservableList<User> getUserObservableList() {
        userObservableList.clear();
        try {
            userObservableList.addAll(usersManagementModel.getAllUsers().getGuests());
            error.set("");
        } catch (RemoteException e) {
            error.set(e.getMessage());
            e.getStackTrace();
        }
        return userObservableList;
    }

    public void deleteGuest(String username) {
        try {
            usersManagementModel.deleteUser(username);
        } catch (RemoteException e) {
            error.set(e.getMessage());
        }
    }
    public void clearFields(){
        companyName.set("");
        CVR.set("");
        phone.set("");
        email.set("");
        password.set("");
    }
}
