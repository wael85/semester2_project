package login;

import client.Login;

import java.io.IOException;

public class LoginModelManger implements LoginModel{
    private Login loginClient;

   public LoginModelManger(Login loginClient){
       this.loginClient = loginClient;
   }
    @Override
    public boolean login(String username, String password) {
        return loginClient.login(username,password);
    }

    @Override
    public void close() throws IOException {

    }
}
