package server;

import sheared_interfaces.RemoteCreateUsers;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        RemoteCreateUsers createUsersImp = new CreateUsersImp();
        registry.bind("create_users" , createUsersImp);
        System.out.println("Server is running on port "+ Registry.REGISTRY_PORT);
    }

}
