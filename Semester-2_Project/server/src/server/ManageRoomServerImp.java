package server;

import dk.via.remote.observer.RemotePropertyChangeListener;
import sheared_interfaces.RemoteManageRoom;
import room_model.Room;
import room_model.Rooms;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ManageRoomServerImp extends UnicastRemoteObject implements RemoteManageRoom {

    public ManageRoomServerImp() throws RemoteException {

    }

    @Override
    public Room createRoom(String roomId, String building, String  floor, String  number, String type, String  capacity) {

        System.out.println(new Room(roomId,building,floor,number,type,capacity));
        return null;
    }

    @Override
    public void deleteRoom(String roomId) throws RemoteException {

    }

    @Override
    public Rooms getAllRooms() throws RemoteException {
        return null;
    }

    @Override
    public void addPropertyChangeListener(RemotePropertyChangeListener<Rooms> listener) throws RemoteException {

    }

    @Override
    public void removePropertyChangeListener(RemotePropertyChangeListener<Rooms> listener) throws RemoteException {

    }
}
