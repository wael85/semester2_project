package database;

import booking.Booking;
import booking.BookingStatus;
import booking.Bookings;
import io.github.cdimascio.dotenv.Dotenv;
import room_model.Room;
import room_model.Rooms;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingImp implements BookingDAO{
    private static BookingImp instance;
    private Dotenv dotenv = Dotenv.load();

    private BookingImp() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }
    public static synchronized BookingImp getInstance() throws SQLException{
        if (instance == null){
            instance = new BookingImp();
        }
        return instance;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://hattie.db.elephantsql.com:5432/zvltjqzb",dotenv.get("USER_NAME"),dotenv.get("PASSWORD"));
    }

    @Override
    public void bookRoom(String bookedBy, String roomId, Timestamp startDateTime, Timestamp endDateTime, boolean isCheckedIn) throws SQLException {
       try(Connection c = getConnection()) {
           PreparedStatement preparedStatement = c.prepareStatement("insert into booking_room_system.booking " +
                   "(bookedby, room_id, start_datetime, end_datetime, first_remainder, last_remainder,ischecked, status)" +
                   " values (?,?,?,?,?,?,?,?);", PreparedStatement.RETURN_GENERATED_KEYS
           );
           preparedStatement.setString(1, bookedBy);
           preparedStatement.setString(2, roomId);
           preparedStatement.setTimestamp(3, startDateTime);
           preparedStatement.setTimestamp(4, endDateTime);
           preparedStatement.setTimestamp(5, new Timestamp(startDateTime.getTime() - 300_000));
           preparedStatement.setTimestamp(6, new Timestamp(startDateTime.getTime() + 1_500_000));
           preparedStatement.setBoolean(7, isCheckedIn);
           preparedStatement.setString(8, "preactive");
           preparedStatement.executeUpdate();
           ResultSet key = preparedStatement.getGeneratedKeys();
           if (key.next()) {
                new Booking(key.getInt(1), bookedBy, roomId, startDateTime, endDateTime);
           } //else return null;
       }
    }

    @Override
    public Rooms getAvailableRooms(Timestamp start, Timestamp end) throws SQLException {
        try (Connection c = getConnection()) {
            PreparedStatement preparedStatement = c.prepareStatement(
                    "select room.room_id ,room.building,room.floor," +
                            "room.number,room.capacity,room.type from booking_room_system.room " +
                            "where booking_room_system.room.room_id not in\n" +
                    "(select room_id from booking_room_system.booking" +
                    " WHERE ((end_datetime = '"+end+"'  AND start_datetime = '"+start+"' ) OR\n" +
                    " (('"+start+"' > start_datetime AND '"+start+"' < end_datetime)  ) OR\n" +
                    " ('"+end+"' > start_datetime AND '"+end+"' < end_datetime) OR\n" +
                    "(start_datetime > '"+start+"' AND start_datetime < '"+end+"')OR\n" +
                    "(end_datetime > '"+start+"' AND end_datetime <'"+end+"')))");
            ResultSet resultSet = preparedStatement.executeQuery();
            Rooms rooms = new Rooms();
            while (resultSet.next()) {
                Room room = new Room(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(6),
                        resultSet.getString(5)
                );
                rooms.addRoom(room);
            }
            return rooms;
        }
    }

    @Override
    public Bookings getUserBooking(String userName) throws SQLException {
        try (Connection c = getConnection()) {
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * from booking_room_system.booking WHERE booking.bookedby = ?;");
            preparedStatement.setString(1,userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Bookings bookings= new Bookings();
            while (resultSet.next()) {
                Booking booking = new Booking(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getTimestamp(4),
                        resultSet.getTimestamp(5)
                );
                booking.setCheckedIn(resultSet.getBoolean(8));
                booking.setStatus(resultSet.getString(9));
                bookings.addBooking(booking);
            }
            return bookings;
        }
    }

    @Override
    public void cancelBooking(Booking booking) throws SQLException {
        try (Connection c = getConnection()) {
            PreparedStatement preparedStatement = c.prepareStatement("DELETE from booking_room_system.booking WHERE booking.booking_number = ?;");
            preparedStatement.setInt(1, booking.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override

    public void removeDeActiveBooking() throws SQLException {
        try (Connection c = getConnection()) {
            PreparedStatement preparedStatement = c.prepareStatement("DELETE FROM booking_room_system.booking\n" +
                    "where end_datetime < current_timestamp OR\n" +
                    "      (current_timestamp >= booking.start_datetime + (30 * interval '1 minutes') and booking.ischecked = false);");

            preparedStatement.executeUpdate();

        }
    }
 @Override
    public void checkIn(Booking booking) throws SQLException {
        try (Connection c= getConnection()){
            PreparedStatement preparedStatement= c.prepareStatement("update booking_room_system.booking\n" +
                    "set ischecked = true\n" +
                    "where booking_number = ?;");
            preparedStatement.setInt(1,booking.getId());
            preparedStatement.executeUpdate();
        }
    }


    @Override
    public ArrayList<String> getAllEmailsToReminder()throws SQLException{
        try (Connection c = getConnection()) {
            PreparedStatement preparedStatement = c.prepareStatement( "SELECT student.email FROM booking_room_system.booking JOIN booking_room_system.student\n" +
                    "ON bookedby = student.user_name_fk\n" +
                    "where (current_timestamp between first_remainder AND start_datetime) OR\n" +
                    "     ( current_timestamp > last_remainder AND ischecked = false);");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<String> emails= new ArrayList<>();
            while (resultSet.next()) {
                emails.add(resultSet.getString(1));
            }
            return emails;
        }
    }
}
