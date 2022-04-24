package client;

import sheared_interfaces.RemoteManageUsers;

import java.beans.PropertyChangeListener;
import java.io.Closeable;
import java.rmi.RemoteException;

public interface ManageUserClientInterface extends Closeable, RemoteManageUsers {
    void addPropertyChangeListener(String event , PropertyChangeListener listener) throws RemoteException;
    void removePropertyChangeListener(PropertyChangeListener listener) throws RemoteException;
}
