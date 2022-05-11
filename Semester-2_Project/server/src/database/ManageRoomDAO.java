package database;

import room_model.Room;
import room_model.Rooms;

import java.sql.SQLException;

public interface ManageRoomDAO {
    Room createRoom(String room_Id, String building, String floor, String number, String type, String capacity) throws SQLException;
    void deleteRoom(String room_Id) throws SQLException;
    Rooms getAllClassRooms() throws SQLException;

    Rooms getAllStudyRooms() throws SQLException;

    Rooms getAllAuditoryRooms() throws SQLException;
    Rooms getAllRooms()throws SQLException;
}
