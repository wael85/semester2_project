package viewModel.login;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import login.LoginModel;

public class LoginViewModel {
    private StringProperty userName;
    private StringProperty password;
    private StringProperty error;
    private LoginModel loginModel;

    public LoginViewModel(LoginModel loginModel){
        this.loginModel = loginModel;
        userName = new SimpleStringProperty("");
        password = new SimpleStringProperty("");
        error = new SimpleStringProperty("");

    }
    public void bindUserName(StringProperty property){
        property.bindBidirectional(userName);

    }
    public void bindPassword(StringProperty property){
        property.bindBidirectional(password);
    }
    public void bindErrorLabel(StringProperty property){
        property.bind(error);
    }
    public boolean login(){
        error.set("");
        boolean login = loginModel.login(userName.get(),password.get());
        if(login){
            error.set("success!!!");
            return true;
        }
        error.set("user name or password is not correct ..");
        return false;
    }
}
