package sheared_interfaces;

import dk.via.remote.observer.RemotePropertyChangeListener;
import room_model.Room;
import room_model.Rooms;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface RemoteManageRoom extends Remote {

    Room createRoom( String building, String floor, String number, String type, String capacity)throws RemoteException;
    void deleteRoom(String roomId)throws RemoteException;
    Rooms getAllRooms()throws RemoteException;
    void addPropertyChangeListener(RemotePropertyChangeListener<Rooms> listener) throws RemoteException;
    void removePropertyChangeListener(RemotePropertyChangeListener<Rooms> listener) throws RemoteException;

}
