package viewModel.administrator;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import users_model.User;
import users_model.Users;
import users_model.UsersManagementModel;

import java.beans.PropertyChangeEvent;


public class ManageTeacherViewModel {
    private UsersManagementModel usersManagementModel;
    private StringProperty firstname;
    private StringProperty lastname;
    private StringProperty staffId;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;
    private StringProperty error;
    private ObservableList<User> userObservableList;

    public ManageTeacherViewModel(UsersManagementModel model) {
        this.usersManagementModel = model;
        userObservableList = FXCollections.observableArrayList();
        usersManagementModel.addPropertyChangeListener("users", evt -> {
            updateUsersList(evt);
        });
        firstname = new SimpleStringProperty("");
        lastname = new SimpleStringProperty("");
        staffId = new SimpleStringProperty("");
        phone = new SimpleStringProperty("");
        email =  new SimpleStringProperty("");
        password = new SimpleStringProperty("");
        error = new SimpleStringProperty("");
    }

    public void bindFirstName (StringProperty property){
        property.bindBidirectional(firstname);
    }
    public void bindLastName (StringProperty property){
        property.bindBidirectional(lastname);
    }
    public void bindStaffId (StringProperty property){
        property.bindBidirectional(staffId);
    }
    public void bindEmail (StringProperty property){
        property.bindBidirectional(email);
    }
    public void bindPhone (StringProperty property){
        property.bindBidirectional(phone);
    }
    public void bindPassword (StringProperty property){
        property.bindBidirectional(password);
    }
    public void bindError(StringProperty property){

        property.bind(error);
    }
    public void createTeacher(){
        try {
            usersManagementModel.createTeacher(staffId.get(),password.get(),firstname.get(),lastname.get(),phone.get(),email.get());
            notification(staffId.getValue()+", add successfully");
        }catch (Exception e){
            notification(e.getMessage());
        }
    }
    public void notification(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public void updateUsersList(PropertyChangeEvent e){
        Platform.runLater(()->{
            userObservableList.clear();
            userObservableList.addAll(((Users) e.getNewValue()).getAdministrators());
        });
    }
    public ObservableList<User> getUserObservableList() {
        return userObservableList;
    }

}
