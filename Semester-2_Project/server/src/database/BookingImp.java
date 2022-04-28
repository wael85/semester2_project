package database;

import booking.Booking;
import booking.BookingStatus;
import io.github.cdimascio.dotenv.Dotenv;

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
        return DriverManager.getConnection("jdbc:postgresql://hattie.db.elephantsql.com:5432/zvltjqzb","postgres","369968");
    }

    @Override
    public Booking bookRoom(String bookedBy, String roomId, Timestamp startDateTime, Timestamp endDateTime) throws SQLException {
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
               return new Booking(key.getInt(1), bookedBy, roomId, startDateTime, endDateTime);
           } else return null;
       }
    }

    public static void main(String[] args) {
        try {
            BookingImp b = new BookingImp();
            Booking d = b.bookRoom("asa","B02-01",new Timestamp(2022-1900,4,12,10,0,3,0),new Timestamp(2022,4,12,13,0,0,0));
            System.out.println(d);
        }catch (SQLException s){
            s.printStackTrace();
        }

    }
}
