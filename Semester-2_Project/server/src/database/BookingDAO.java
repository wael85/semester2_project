package database;

import booking.Booking;
import booking.Bookings;
import room_model.Rooms;

import java.sql.SQLException;
import java.sql.Timestamp;

public interface BookingDAO {
    void bookRoom(String bookedBy, String roomId, Timestamp startDateTime, Timestamp endDateTime ) throws SQLException;
    Rooms getAvailableRooms(Timestamp start , Timestamp end) throws SQLException;
    Bookings getUserBooking(String userName) throws SQLException;
    void cancelBooking(Booking booking) throws SQLException;
    void removeDeActiveBooking() throws SQLException;
}
