package client;

import booking.Booking;
import dk.via.remote.observer.RemotePropertyChangeEvent;
import dk.via.remote.observer.RemotePropertyChangeListener;
import room_model.Rooms;
import sheared_interfaces.RemoteBookingInterface;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Timestamp;

public class ClientBooking extends UnicastRemoteObject implements ClientBookingInterface, RemotePropertyChangeListener<Rooms> {
    private Registry registry;
    private RemoteBookingInterface remoteBooking;
    private PropertyChangeSupport support;

    public ClientBooking(Registry registry) throws RemoteException, NotBoundException {
        this.registry = registry;
        remoteBooking = (RemoteBookingInterface) this.registry.lookup("booking");
        this.support = new PropertyChangeSupport(this);
        remoteBooking.addPropertyChangeListener(this);
    }


    @Override
    public void createBooking(String bookBy, String roomId, Timestamp start, Timestamp end) throws RemoteException {
        remoteBooking.createBooking(bookBy, roomId, start, end);
    }

    @Override
    public Rooms getAvailableRooms(Timestamp start, Timestamp end) throws RemoteException {
        return remoteBooking.getAvailableRooms(start, end);
    }

    @Override
    public Bookings getUserBooking(String userName) throws RemoteException {
        return remoteBooking.getUserBooking(userName);
    }


    @Override
    public void cancelBooking(Booking booking) throws RemoteException {
        remoteBooking.cancelBooking(booking);
    }

    @Override
    public void addPropertyChangeListener(String event, PropertyChangeListener listener) throws RemoteException {
        support.addPropertyChangeListener(event, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) throws RemoteException {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public void close() throws IOException {
        remoteBooking.removePropertyChangeListener(this);
        UnicastRemoteObject.unexportObject(this, true);
    }

    // no use for it
    @Override
    public void addPropertyChangeListener(RemotePropertyChangeListener<Rooms> listener) throws RemoteException {

    }

    // no use for it
    @Override
    public void removePropertyChangeListener(RemotePropertyChangeListener<Rooms> listener) throws RemoteException {

    }


    @Override
    public void propertyChange(RemotePropertyChangeEvent<Rooms> event) throws RemoteException {
        support.firePropertyChange(event.getPropertyName(), event.getOldValue(), event.getNewValue());
    }
}
