package database;

import booking.Booking;

import java.sql.SQLException;
import java.sql.Timestamp;

public interface BookingDAO {
    Booking bookRoom( String bookedBy, String roomId, Timestamp startDateTime, Timestamp endDateTime) throws SQLException;
}
