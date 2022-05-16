package client;

import sheared_interfaces.RemoteBookingInterface;

import java.beans.PropertyChangeListener;
import java.io.Closeable;
import java.rmi.RemoteException;

public interface ClientBookingInterface extends Closeable, RemoteBookingInterface {
    void addPropertyChangeListener(String event , PropertyChangeListener listener) throws RemoteException;
    void removePropertyChangeListener(PropertyChangeListener listener) throws RemoteException;
}
