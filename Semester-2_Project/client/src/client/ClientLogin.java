package client;

import sheared_interfaces.RemoteLogin;
import users_model.User;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ClientLogin extends UnicastRemoteObject implements ClientLoginInterface, RemoteLogin {
    private Registry registry;
    private RemoteLogin remoteLogin;

    public ClientLogin(Registry registry) throws RemoteException, NotBoundException {
        this.registry = registry;
         remoteLogin = (RemoteLogin) this.registry.lookup("login");
    }
    @Override
    public boolean login(String userName, String password) throws RemoteException {
      return remoteLogin.login(userName,password);
    }

    @Override
    public User getUser(String userName) throws RemoteException {
        return remoteLogin.getUser(userName);
    }

    @Override
    public void close() throws IOException {
        UnicastRemoteObject.unexportObject(this,true);
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        ClientLogin c = new ClientLogin(LocateRegistry.getRegistry("localhost", Registry.REGISTRY_PORT));
        System.out.println( c.login("th","222"));
        System.out.println(c.getUser("tch"));
    }
}
