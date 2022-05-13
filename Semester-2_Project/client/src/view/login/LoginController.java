package view.login;

import javafx.fxml.FXML;
import users_model.UsersTypes;
import view.ViewHandler;
import viewModel.ViewModelFactory;
import viewModel.login.LoginViewModel;

import javafx.scene.control.*;

import java.rmi.RemoteException;

public class LoginController {
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    private Label error;
    private LoginViewModel loginViewModel;
    private ViewHandler viewHandler;

    public void  init(LoginViewModel loginViewModel , ViewHandler viewHandler){
        this.loginViewModel = loginViewModel;
        this.viewHandler = viewHandler;
        this.loginViewModel.bindErrorLabel(error.textProperty());
        this.loginViewModel.bindPassword(password.textProperty());
        this.loginViewModel.bindUserName(userName.textProperty());

    }
    @FXML
    public void login(){
      if( loginViewModel.login()){
          switch (viewHandler.getCurrentUser().getCurrentUser().getUserType()){
              case "ADMINISTRATOR":
                  viewHandler.openMainMenu();
              case "STUDENT":
                  viewHandler.openManageRoom();
          }
      }
    }
}
