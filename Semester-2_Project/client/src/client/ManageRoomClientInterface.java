package client;

import sheared_interfaces.RemoteManageRoom;

import java.beans.PropertyChangeListener;
import java.io.Closeable;
import java.rmi.RemoteException;

public interface ManageRoomClientInterface extends Closeable, RemoteManageRoom {
    void addPropertyChangeListener(String event , PropertyChangeListener listener) throws RemoteException;
    void removePropertyChangeListener(PropertyChangeListener listener) throws RemoteException;
}
