package database;

import booking.Booking;
import booking.BookingStatus;
import booking.Bookings;
import io.github.cdimascio.dotenv.Dotenv;
import room_model.Room;
import room_model.Rooms;

import java.sql.*;

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
       // return DriverManager.getConnection("jdbc:postgresql://localhost:5432/sep2_project?currentSchema=booking_room_system", "postgres", "1230");

    }

    @Override
    public void bookRoom(String bookedBy, String roomId, Timestamp startDateTime, Timestamp endDateTime) throws SQLException {
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
           preparedStatement.setBoolean(7, false);
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
            PreparedStatement preparedStatement = c.prepareStatement("SELECT room.room_id ,room.building,room.floor,room.number,room.type ,room.capacity\n" +
                    "FROM booking_room_system.room LEFT OUTER JOIN\n" +
                    "    booking_room_system.booking b ON\n" +
                    "    room.room_id = b.room_id\n" +
                    "WHERE ((b.end_datetime <= '" + start + "' AND b.end_datetime < '" + end + "' ) OR\n" +
                    "      (b.start_datetime > '" + start + "' AND b.start_datetime >= '" + end + "')) OR\n" +
                    "      (b.booking_number IS NULL )" +
                    "group by room.room_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            Rooms rooms = new Rooms();
            while (resultSet.next()) {
                Room room = new Room(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
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
}
