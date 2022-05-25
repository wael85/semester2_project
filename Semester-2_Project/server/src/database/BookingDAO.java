package database;

import booking.Booking;
import booking.Bookings;
import room_model.Rooms;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public interface BookingDAO {
    void bookRoom(String bookedBy, String roomId, Timestamp startDateTime, Timestamp endDateTime,boolean isCheckedIn ) throws SQLException;
    Rooms getAvailableRooms(Timestamp start , Timestamp end) throws SQLException;
    Bookings getUserBooking(String userName) throws SQLException;
    void cancelBooking(Booking booking) throws SQLException;
    void removeDeActiveBooking() throws SQLException;
    void checkIn(Booking booking)throws SQLException;
    ArrayList<String> getAllEmailsToReminder() throws SQLException;
}
