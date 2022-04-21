package viewModel.administrator;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import model.UsersManagementModel;

public class AddGuestViewModel {
    private UsersManagementModel usersManagementModel;
    private StringProperty companyName;
    private StringProperty CVR;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;
    private StringProperty error;
    public AddGuestViewModel(UsersManagementModel model) {
        this.usersManagementModel = model;

        companyName = new SimpleStringProperty("");
        CVR = new SimpleStringProperty("");
        phone = new SimpleStringProperty("");
        email =  new SimpleStringProperty("");
        password = new SimpleStringProperty("");
        error = new SimpleStringProperty("");

    }
    public void bindCompanyName (StringProperty property){
        property.bindBidirectional(companyName);
    }
    public void bindCVR (StringProperty property){
        property.bindBidirectional(CVR);
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
    public void createGuest(){
        try {
            usersManagementModel.createGuest(CVR.get(),password.get(),companyName.get(),phone.get(),email.get());
            notification(CVR.getValue()+", add successfully");

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
