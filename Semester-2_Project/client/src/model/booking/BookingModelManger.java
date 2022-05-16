package model.booking;

import booking.Booking;
import booking.Bookings;
import client.ClientBookingInterface;
import room_model.Rooms;
import user_state.UserState;

import java.rmi.RemoteException;
import java.sql.Timestamp;

public class BookingModelManger implements BookingModel {
     private ClientBookingInterface client;
     private UserState currentUser;

    public BookingModelManger(ClientBookingInterface clientBooking, UserState currentUser) {
        this.client = clientBooking;
        this.currentUser = currentUser;
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
}
