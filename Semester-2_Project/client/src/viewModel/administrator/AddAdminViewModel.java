package viewModel.administrator;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import model.UsersManagementModel;

public class AddAdminViewModel {
    private UsersManagementModel usersManagementModel;
    private StringProperty firstname;
    private StringProperty lastname;
    private StringProperty adminId;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;
    private StringProperty error;


    public AddAdminViewModel(UsersManagementModel usersManagementModel) {
        this.usersManagementModel = usersManagementModel;
        firstname = new SimpleStringProperty("");
        lastname = new SimpleStringProperty("");
        adminId = new SimpleStringProperty("");
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
    public void bindAdminId (StringProperty property){
        property.bindBidirectional(adminId);
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
    public void createAdmin(){
        try {
            usersManagementModel.createAdmin(adminId.get(),firstname.get(),lastname.get(),phone.get(),email.get(),password.get());
            notification(adminId.getValue()+", add successfully");
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