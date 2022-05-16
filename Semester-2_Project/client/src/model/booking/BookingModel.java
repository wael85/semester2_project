package model.booking;

import booking.Booking;
import booking.Bookings;
import room_model.Rooms;

import java.rmi.RemoteException;
import java.sql.Timestamp;

public interface BookingModel {
    void createBooking( String roomId, Timestamp start, Timestamp end) throws RemoteException;
    Rooms getAvailableRooms(Timestamp start, Timestamp end)throws RemoteException;
    Bookings getUserBooking()throws RemoteException;
    void cancelBooking(Booking booking) throws RemoteException;
}
