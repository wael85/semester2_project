package server;

import database.ManageRoomDAO;
import sheared_interfaces.RemoteBookingInterface;
import sheared_interfaces.RemoteLogin;
import sheared_interfaces.RemoteManageRoom;
import sheared_interfaces.RemoteManageUsers;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

public class Server {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, SQLException {
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        RemoteManageUsers manageUsersServerImp = new ManageUsersServerImp();
        RemoteManageRoom manageRoomServerImp = new ManageRoomServerImp();
        RemoteBookingInterface remoteBooking = new BookingServerImp();
        RemoteLogin login = new LoginServerImp();
        registry.bind("manage_users" , manageUsersServerImp);
        registry.bind("manage_room",manageRoomServerImp);
        registry.bind("login",login);
        registry.bind("booking",remoteBooking);
        CleanOldBooking cleanOldBooking = new CleanOldBooking();
        Thread thread = new Thread(cleanOldBooking);
        thread.start();
        System.out.println("Server is running on port "+ Registry.REGISTRY_PORT);
    }

}
