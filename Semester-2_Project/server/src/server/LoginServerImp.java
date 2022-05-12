package server;

import database.LoginDAO;
import database.LoginImp;
import sheared_interfaces.RemoteLogin;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class LoginServerImp implements RemoteLogin {
    private LoginDAO loginDAO;

    public LoginServerImp() throws SQLException {
      loginDAO = LoginImp.getInstance();
    }

    @Override
    public String login(String userName, String password) throws RemoteException {
        try {
            if( loginDAO.login(userName,password)){
                return "it is true";
            }
        }catch (SQLException e){
            throw new RemoteException(e.getMessage() ,e);
        }finally {
            return "ir is false";
        }
    }
}
