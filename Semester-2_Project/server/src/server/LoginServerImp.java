package server;

import database.LoginDAO;
import database.LoginImp;
import sheared_interfaces.RemoteLogin;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class LoginServerImp extends UnicastRemoteObject implements RemoteLogin {
    private LoginDAO loginDAO;

    public LoginServerImp() throws RemoteException,SQLException {
      loginDAO = LoginImp.getInstance();
    }

    @Override
    public Boolean login(String userName, String password) throws RemoteException, SQLException {
       return loginDAO.login(userName,password);
    }
}
