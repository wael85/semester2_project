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
    private PasswordField password;
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
        reset();

    }
    @FXML
    public void login(){
      if( loginViewModel.login()){
          String user = viewHandler.getCurrentUser().getCurrentUser().getUserType();
          switch (user){
              case "ADMINISTRATOR":
                  viewHandler.openMainMenu();
                  break;
              case "STUDENT":
                  viewHandler.openStudentBooking();
                  break;
              case "TEACHER":
                  viewHandler.openTeacherBooking();
                  break;
              case "GUEST":
                  viewHandler.openGuestBooking();
                  break;
              default: viewHandler.openLogin();
          }
      }
    }
    public void reset(){
        userName.setText("");
        password.setText("");
    }
}
