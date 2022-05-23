package viewModel.login;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.login.LoginModel;

import javax.swing.*;
import java.rmi.RemoteException;

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
    public boolean login() {
        try {
            error.set("");
           boolean t = loginModel.login(userName.get(),password.get());
           if(t == false){
               JOptionPane.showMessageDialog(null,"UserName Or Password is incorrect !!");
           }
           return t;
        }catch (RemoteException e){
            error.set("");
            error.set(e.getMessage());
            return false;
        }
    }
}
