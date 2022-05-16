package sheared_interfaces;

import booking.Booking;
import dk.via.remote.observer.RemotePropertyChangeListener;
import room_model.Rooms;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Timestamp;

public interface RemoteBookingInterface extends Remote {
    void createBooking(String bookBy, String roomId, Timestamp start, Timestamp end) throws RemoteException;
    Rooms getAvailableRooms(Timestamp start, Timestamp end)throws RemoteException;
    Bookings getUserBooking(String userName)throws RemoteException;
    void cancelBooking(Booking booking) throws RemoteException;
    void addPropertyChangeListener(RemotePropertyChangeListener<Rooms> listener) throws RemoteException;

    void removePropertyChangeListener(RemotePropertyChangeListener<Rooms> listener) throws RemoteException;


}