package database;

import room_model.Room;
import room_model.Rooms;

import java.sql.SQLException;

public interface ManageRoomDAO {
    Room createRoom( String building, String floor, String number, String type, String capacity) throws SQLException;
    void deleteRoom(String room_Id) throws SQLException;
    Rooms getRooms() throws SQLException;

}
