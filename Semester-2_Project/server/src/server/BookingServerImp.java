package server;

import booking.Booking;
import database.BookingDAO;
import database.BookingImp;
import dk.via.remote.observer.RemotePropertyChangeListener;
import dk.via.remote.observer.RemotePropertyChangeSupport;
import room_model.Rooms;
import sheared_interfaces.RemoteBookingInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.sql.Timestamp;

public class BookingServerImp extends UnicastRemoteObject implements RemoteBookingInterface {
   private BookingDAO bookingDAO;
    private final RemotePropertyChangeSupport<Rooms> support;


    public BookingServerImp() throws SQLException, RemoteException {

        this.bookingDAO= BookingImp.getInstance();
        this.support = new RemotePropertyChangeSupport<>(this);

    }


    @Override
    public void createBooking(String bookBy, String roomId, Timestamp start, Timestamp end) throws RemoteException {
        try {
            bookingDAO.bookRoom(bookBy, roomId, start, end);
            support.firePropertyChange("getAvailableRooms",null,null);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Rooms getAvailableRooms(Timestamp start, Timestamp end) {
      return bookingDAO.getAvailableRooms(start,end);

    }

    @Override
    public Bookings getUserBooking(String userName) {
      return bookingDAO.getUserBooking(userName);
    }

    @Override
    public void cancelBooking(Booking booking) throws RemoteException {
        bookingDAO.cancelBooking(booking);
        support.firePropertyChange("getAvailableRooms",null,null);
    }

    @Override
    public void addPropertyChangeListener(RemotePropertyChangeListener<Rooms> listener) throws RemoteException {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(RemotePropertyChangeListener<Rooms> listener) throws RemoteException {
        support.removePropertyChangeListener(listener);
    }
}
