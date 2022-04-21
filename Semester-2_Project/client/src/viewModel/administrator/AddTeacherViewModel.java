package viewModel.administrator;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import model.UsersManagementModel;


public class AddTeacherViewModel {
    private UsersManagementModel usersManagementModel;
    private StringProperty firstname;
    private StringProperty lastname;
    private StringProperty staffId;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;
    private StringProperty error;

    public AddTeacherViewModel(UsersManagementModel model) {
        this.usersManagementModel = model;
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

}
