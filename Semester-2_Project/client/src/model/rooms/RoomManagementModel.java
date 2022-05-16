package model.rooms;

import room_model.Room;
import room_model.Rooms;

import java.beans.PropertyChangeListener;
import java.io.Closeable;
import java.rmi.RemoteException;

public interface RoomManagementModel extends Closeable {
    Room createRoom(String building, String floor, String number, String type, String capacity) throws RemoteException;
    Rooms getAllRooms() throws RemoteException;
    void deleteRoom(String roomId) throws RemoteException;
    void addPropertyChangeListener (String evt , PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
}
