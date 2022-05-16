package model.login;

import client.ClientLoginInterface;
import model.login.LoginModel;
import user_state.UserState;
import users_model.User;

import java.io.IOException;
import java.rmi.RemoteException;

public class LoginModelManger implements LoginModel {
    private ClientLoginInterface loginClient;
    private UserState currentUser;

   public LoginModelManger(ClientLoginInterface loginClient, UserState currentUser){
       this.loginClient = loginClient;
       this.currentUser = currentUser;
   }
    @Override
    public boolean login(String username, String password) throws RemoteException {
        boolean isLogin = loginClient.login(username,password);
        if(isLogin){
           currentUser.setCurrentUser(getUser(username));
           return true;
        }return false;
    }

    @Override
    public User getUser(String userName) throws RemoteException {
        return loginClient.getUser(userName);
    }

    @Override
    public void close() throws IOException {
       loginClient.close();
    }
}
