package server;

import database.LoginDAO;
import database.LoginImp;
import sheared_interfaces.RemoteLogin;
import users_model.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class LoginServerImp extends UnicastRemoteObject implements RemoteLogin {
    private LoginDAO loginDAO;

    public LoginServerImp() throws SQLException,RemoteException {
      loginDAO = LoginImp.getInstance();
    }

    @Override
    public boolean login(String userName, String password) throws RemoteException {
        try {
            return loginDAO.login(userName,password);
        }catch (SQLException e){
            throw new RemoteException(e.getMessage() ,e);
        }
    }

    @Override
    public User getUser(String userName) throws RemoteException {
        try {
            return loginDAO.getUser(userName);
        }catch (SQLException e){
            throw new RemoteException(e.getMessage() ,e);
        }
    }

}
