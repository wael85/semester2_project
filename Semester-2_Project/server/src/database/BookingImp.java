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
                    "WHERE ((b.end_datetime <= '" + start + "' AND b.end_datetime <= '" + end + "' ) OR\n" +
                    "      (b.start_datetime >= '" + start + "' AND b.start_datetime >= '" + end + "')) OR\n" +
                    "      (b.booking_number IS NULL );");
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
        return null;
    }

    @Override
    public void cancelBooking(Booking booking) throws SQLException {

    }

    public static void main(String[] args) {
        try {
            BookingImp b = new BookingImp();
           //  b.bookRoom("waehad","B1-10",new Timestamp(2022-1900,4,12,8,0,3,0),new Timestamp(2022-1900,4,12,9,0,0,0));
         //   b.bookRoom("315315","C2-2",new Timestamp(2022-1900,4,12,12,0,3,0),new Timestamp(2022-1900,4,12,13,0,0,0));
            System.out.println(b.getAvailableRooms(new Timestamp(2022-1900,4,12,9,0,0,0),new Timestamp(2022-1900,4,12,11,0,0,0)));
        }catch (SQLException s){
            s.printStackTrace();
        }

    }
}
