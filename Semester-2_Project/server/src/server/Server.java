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
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
        SendReminder sendReminder = new SendReminder();
        Thread thread = new Thread(cleanOldBooking);
        Thread sendSMS = new Thread(sendReminder);
        thread.start();
        sendSMS.start();
        System.out.println("Server is running on port "+ Registry.REGISTRY_PORT);
    }

}
