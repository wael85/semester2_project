package login;

import client.Login;

import java.io.IOException;
import java.rmi.RemoteException;

public class LoginModelManger implements LoginModel{
    private Login loginClient;

   public LoginModelManger(Login loginClient){
       this.loginClient = loginClient;
   }
    @Override
    public boolean login(String username, String password) throws RemoteException {
       // return loginClient.login(username,password);
        return true;
    }

    @Override
    public void close() throws IOException {

    }
}
