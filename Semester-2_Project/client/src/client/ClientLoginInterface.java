package client;

import users_model.User;

import java.io.Closeable;
import java.rmi.RemoteException;

public interface ClientLoginInterface extends Closeable {
    boolean login(String userName, String password) throws RemoteException;
    User getUser(String userName) throws RemoteException;
}
