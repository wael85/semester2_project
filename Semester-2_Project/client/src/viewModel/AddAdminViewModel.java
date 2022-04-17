package viewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import users_model.UsersManagementModel;

import java.sql.SQLException;

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
            error.set("");
        }catch (Exception e){
            error.set(e.getMessage());
        }
    }

}
