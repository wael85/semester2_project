package model.login;

import users_model.User;

import java.io.Closeable;
import java.rmi.RemoteException;

public interface LoginModel extends Closeable {
    boolean login (String username ,String password) throws RemoteException;
    User getUser (String userName) throws RemoteException;
}
