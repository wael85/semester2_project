package database;

import io.github.cdimascio.dotenv.Dotenv;
import room_model.Room;
import room_model.RoomTypes;
import room_model.Rooms;

import java.sql.*;
public class ManageRoomImp implements ManageRoomDAO {
    private static ManageRoomImp instance;
    private Dotenv dotenv = Dotenv.load();

    private ManageRoomImp() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized ManageRoomImp getInstance() throws SQLException {
        if (instance == null) {
            instance = new ManageRoomImp();
        }
        return instance;

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://hattie.db.elephantsql.com:5432/zvltjqzb",dotenv.get("USER_NAME"),dotenv.get("PASSWORD"));
       // return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "369968");
        //return DriverManager.getConnection("jdbc:postgresql://localhost:5432/sep2_project?currentSchema=booking_room_system","postgres","1230");

    }

    @Override
    public Room createRoom( String building, String floor, String number, String type, String capacity) throws SQLException {
       String room_Id = building+floor+"-"+number;
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into booking_room_system.room (building,floor,number,type,capacity,room_Id)\n" +
                    "values (?,?,?,?,?,?);\n");
            statement.setString(1, building);
            statement.setString(2, floor);
            statement.setString(3, number);
            statement.setString(4, type);
            statement.setInt(5, Integer.parseInt(capacity));
            statement.setString(6, room_Id);
            statement.executeUpdate();
            return new Room(room_Id, building, floor, number, type, capacity);

        }
    }

    @Override
    public void deleteRoom(String room_Id) throws SQLException {
        try(Connection c = getConnection()) {
            PreparedStatement preparedStatement = c.prepareStatement("delete\n" +
                    "from booking_room_system.room\n" +
                    "where room_id = ?;");
            preparedStatement.setString(1,room_Id);
            preparedStatement.executeUpdate();
        }
    }


        @Override
        public Rooms getRooms () throws SQLException {

        Rooms rooms = new Rooms();
        try (Connection c = getConnection()) {
            PreparedStatement preparedStatement = c.prepareStatement("select *\n" +
                    "From booking_room_system.room");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Room room = new Room(resultSet.getString(6),
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
                rooms.addRoom(room);
            }
            return rooms;
        }
    }


}
