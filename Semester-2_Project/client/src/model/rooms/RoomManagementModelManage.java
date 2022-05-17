package model.rooms;

import client.ManageRoomClientInterface;
import model.inputValidation.ValidatorManageRooms;
import model.rooms.RoomManagementModel;
import room_model.Room;
import room_model.Rooms;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.rmi.RemoteException;

public class RoomManagementModelManage implements RoomManagementModel {

    private ManageRoomClientInterface client;
    private PropertyChangeSupport support;

    public RoomManagementModelManage(ManageRoomClientInterface client) throws RemoteException {
        this.client = client;
        support = new PropertyChangeSupport(this);
        client.addPropertyChangeListener("rooms",evt -> updateRoomList(evt));
    }

    @Override
    public Room createRoom(String building, String floor, String number, String type, String capacity) throws RemoteException {
        ValidatorManageRooms.validatorCreateRoom(building, floor, number, type, capacity);
        return client.createRoom(building, floor, number, type, capacity);
    }

    @Override
    public Rooms getAllRooms() throws RemoteException {
        return client.getAllRooms();
    }

    @Override
    public void deleteRoom(String roomId) throws RemoteException {
        client.deleteRoom(roomId);
    }

    @Override
    public void addPropertyChangeListener(String evt, PropertyChangeListener listener) {
        support.addPropertyChangeListener(evt,listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
    public void updateRoomList(PropertyChangeEvent event){
        support.firePropertyChange("rooms", null,event.getNewValue());
    }

    @Override
    public void close() throws IOException {
        client.close();
    }
}
