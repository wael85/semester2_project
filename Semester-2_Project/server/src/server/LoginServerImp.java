package server;

import sheared_interfaces.RemoteLogin;

import java.rmi.RemoteException;

public class LoginServerImp implements RemoteLogin {

    public LoginServerImp(){

    }

    @Override
    public boolean login(String userName, String password) throws RemoteException {
        return false;
    }
}
