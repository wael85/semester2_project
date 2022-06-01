package server;

import database.ManageRoomDAO;
import database.ManageRoomImp;
import database.ManageUserDAO;
import database.ManageUserImp;
import dk.via.remote.observer.RemotePropertyChangeListener;
import dk.via.remote.observer.RemotePropertyChangeSupport;
import sheared_interfaces.RemoteManageRoom;
import room_model.Room;
import room_model.Rooms;
import users_model.Users;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class ManageRoomServerImp extends UnicastRemoteObject implements RemoteManageRoom {
    private final ManageRoomDAO manageRoomDAO;
    private final RemotePropertyChangeSupport<Rooms> support;

    public ManageRoomServerImp() throws RemoteException, SQLException {
        manageRoomDAO = ManageRoomImp.getInstance();
        this.support = new RemotePropertyChangeSupport<>(this);
    }

    @Override
    public Room createRoom( String building, String  floor, String  number, String type, String  capacity) throws RemoteException{
       try {
         Room room =   manageRoomDAO.createRoom(building,floor,number,type,capacity);
         support.firePropertyChange("rooms",null,getAllRooms());
         return room;
       }catch (SQLException ex){
           throw new RemoteException(ex.getMessage(),ex);
       }
    }

    @Override
    public void deleteRoom(String roomId) throws RemoteException {
        try {
            manageRoomDAO.deleteRoom(roomId);
            support.firePropertyChange("rooms",null,getAllRooms());
        }catch (SQLException e){
            throw new RemoteException(e.getMessage(),e);
        }
    }

    @Override
    public Rooms getAllRooms() throws RemoteException {
        try {
            return manageRoomDAO.getRooms();
        }catch (SQLException ex){
            throw new RemoteException(ex.getMessage(),ex);
        }
    }

    @Override
    public void addPropertyChangeListener(RemotePropertyChangeListener<Rooms> listener) throws RemoteException {
                support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(RemotePropertyChangeListener<Rooms> listener) throws RemoteException {
                support.removePropertyChangeListener(listener);
    }
}
