package server;

import booking.Booking;
import booking.Bookings;
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
import java.time.LocalDateTime;
import java.util.Date;

public class BookingServerImp extends UnicastRemoteObject implements RemoteBookingInterface {
   private BookingDAO bookingDAO;
    private final RemotePropertyChangeSupport<Rooms> support;


    public BookingServerImp() throws RemoteException {

       try {
           this.bookingDAO= BookingImp.getInstance();
           this.support = new RemotePropertyChangeSupport<>(this);
       }catch (SQLException x){
           throw new RemoteException(x.getMessage(),x);
       }

    }


    @Override
    public void createBooking(String bookBy, String roomId, Timestamp start, Timestamp end , boolean isCheckedIn) throws RemoteException {
        try {
            bookingDAO.bookRoom(bookBy, roomId, start, end, isCheckedIn);
            support.firePropertyChange("getAvailableRooms",null,getAvailableRooms(
                    new Timestamp(LocalDateTime.now().getNano()),new Timestamp(LocalDateTime.now().getNano()+3600_000)
            ));

        } catch (SQLException e) {
            throw new RemoteException( e.getMessage() , e);
        }
    }

    @Override
    public Rooms getAvailableRooms(Timestamp start, Timestamp end) throws RemoteException {
      try {
          return bookingDAO.getAvailableRooms(start,end);
      }catch (SQLException sql){
          throw new RemoteException(sql.getMessage(), sql);
      }

    }

    @Override
    public Bookings getUserBooking(String userName) throws RemoteException {
        try {
            return bookingDAO.getUserBooking(userName);
        } catch (SQLException e) {
            throw new RemoteException( e.getMessage() , e);
        }
    }

    @Override
    public void cancelBooking(Booking booking) throws RemoteException {
        try {
            bookingDAO.cancelBooking(booking);
            support.firePropertyChange("getAvailableRooms",null,getAvailableRooms(
                    new Timestamp(LocalDateTime.now().getNano()),new Timestamp(LocalDateTime.now().getNano()+3600_000)
            ));
        } catch (SQLException e) {
            throw new RemoteException( e.getMessage() , e);
        }

    }

    @Override
    public void checkIn(Booking booking) throws RemoteException {
        try {
            bookingDAO.checkIn(booking);
        } catch (SQLException e) {
            throw new RemoteException( e.getMessage() , e);
        }

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
