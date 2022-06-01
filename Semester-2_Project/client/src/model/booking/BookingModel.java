package model.booking;

import booking.Booking;
import booking.Bookings;
import room_model.Rooms;
import user_state.UserState;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Closeable;
import java.rmi.RemoteException;
import java.sql.Timestamp;

public interface BookingModel extends Closeable {
    void createBooking( String roomId, Timestamp start, Timestamp end) throws RemoteException;
    Rooms getAvailableRooms(Timestamp start, Timestamp end)throws RemoteException;
    Bookings getUserBooking()throws RemoteException;
    void cancelBooking(Booking booking) throws RemoteException;
    void addPropertyChangeListener(String evt, PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
    UserState getCurrentUser();
    void checkIn(Booking booking) throws RemoteException;
    void updateAvailableRooms(PropertyChangeEvent evt);

}
