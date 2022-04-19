package server;

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
        //manageUsersServerImp.createAdmin("asd","sds","sd","sfsf","sdfs","sds,");
        registry.bind("create_users" , manageUsersServerImp);
        System.out.println("Server is running on port "+ Registry.REGISTRY_PORT);
    }

}
