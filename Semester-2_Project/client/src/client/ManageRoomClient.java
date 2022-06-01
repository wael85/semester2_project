package client;

import dk.via.remote.observer.RemotePropertyChangeEvent;
import dk.via.remote.observer.RemotePropertyChangeListener;
import sheared_interfaces.RemoteManageRoom;
import room_model.Room;
import room_model.Rooms;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ManageRoomClient extends UnicastRemoteObject implements ManageRoomClientInterface, RemotePropertyChangeListener<Rooms> {

    private RemoteManageRoom remoteManageRoom;
    private PropertyChangeSupport support;

    public ManageRoomClient(Registry registry) throws RemoteException, NotBoundException {
        remoteManageRoom = (RemoteManageRoom) registry.lookup("manage_room");
        remoteManageRoom.addPropertyChangeListener(this);
        support= new PropertyChangeSupport(this);

    }

    @Override
    public Room createRoom(String building, String floor, String number, String type, String capacity) throws RemoteException {
        return remoteManageRoom.createRoom(building, floor, number, type, capacity);
    }

    @Override
    public void deleteRoom(String roomId) throws RemoteException {
        remoteManageRoom.deleteRoom(roomId);
    }

    @Override
    public Rooms getAllRooms() throws RemoteException {
        return remoteManageRoom.getAllRooms();
    }
    // no use for it
    @Override
    public void addPropertyChangeListener(RemotePropertyChangeListener<Rooms> listener) throws RemoteException {

    }
    // no use for it
    @Override
    public void removePropertyChangeListener(RemotePropertyChangeListener<Rooms> listener) throws RemoteException {

    }

    @Override
    public void addPropertyChangeListener(String event, PropertyChangeListener listener) throws RemoteException {
        support.addPropertyChangeListener(event,listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) throws RemoteException {
        support.removePropertyChangeListener(listener);
    }


    @Override
    public void close() throws IOException {
        remoteManageRoom.removePropertyChangeListener(this);
        UnicastRemoteObject.unexportObject(this,true);
    }

    @Override
    public void propertyChange(RemotePropertyChangeEvent<Rooms> changeEvent) throws RemoteException {
        support.firePropertyChange(changeEvent.getPropertyName(),changeEvent.getOldValue(),changeEvent.getNewValue());
    }

}
