package client;

import sheared_interfaces.RemoteLogin;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class ClientLogin extends UnicastRemoteObject implements Login, RemoteLogin {
    private Registry registry;
    private RemoteLogin remoteLogin;

    public ClientLogin(Registry registry) throws RemoteException, NotBoundException {
        this.registry = registry;
         remoteLogin = (RemoteLogin) this.registry.lookup("login");
    }
    @Override
    public Boolean login(String userName, String password) throws RemoteException, SQLException {
     return remoteLogin.login(userName,password);
    }

    @Override
    public void close() throws IOException {

    }

    public static void main(String[] args) throws RemoteException, NotBoundException, SQLException {
        ClientLogin c = new ClientLogin(LocateRegistry.getRegistry("localhost", Registry.REGISTRY_PORT));
        System.out.println( c.login("tch","222"));
    }
}
