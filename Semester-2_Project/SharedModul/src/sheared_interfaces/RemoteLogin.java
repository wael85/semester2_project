package sheared_interfaces;

import users_model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteLogin extends Remote {
    boolean login(String userName , String password) throws RemoteException;
    User getUser(String userName) throws RemoteException;
}
