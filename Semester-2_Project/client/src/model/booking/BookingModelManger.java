package model.booking;

import booking.Booking;
import booking.Bookings;
import client.ClientBookingInterface;
import room_model.Rooms;
import user_state.UserState;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Timestamp;

public class BookingModelManger implements BookingModel {
     private ClientBookingInterface client;
     private UserState currentUser;
    private PropertyChangeSupport support;

    public BookingModelManger(ClientBookingInterface clientBooking, UserState currentUser) throws RemoteException {
        this.client = clientBooking;
        this.currentUser = currentUser;
        support = new PropertyChangeSupport(this);
        client.addPropertyChangeListener("getAvailableRooms",evt ->  updateAvailableRooms(evt));
    }

    public UserState getCurrentUser() {
        return currentUser;
    }

    @Override
    public void checkIn(Booking booking) throws RemoteException {
        client.checkIn(booking);
    }

    @Override
    public void createBooking( String roomId, Timestamp start, Timestamp end) throws RemoteException {
        client.createBooking(currentUser.getCurrentUser().getUserName(), roomId,start,end);
    }

    @Override
    public Rooms getAvailableRooms(Timestamp start, Timestamp end) throws RemoteException {
        return client.getAvailableRooms(start,end);
    }

    @Override
    public Bookings getUserBooking() throws RemoteException {
        return client.getUserBooking(currentUser.getCurrentUser().getUserName());
    }

    @Override
    public void cancelBooking(Booking booking) throws RemoteException {
          client.cancelBooking(booking);
    }
    private void updateAvailableRooms(PropertyChangeEvent evt) {
        support.firePropertyChange("getAvailableRooms",null,evt.getNewValue());
    }
    @Override
    public void addPropertyChangeListener(String evt, PropertyChangeListener listener) {
        support.addPropertyChangeListener(evt,listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public void close() throws IOException {
        client.close();
    }
}
