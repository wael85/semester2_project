package client;

import sheared_interfaces.RemoteLogin;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ClientLogin extends UnicastRemoteObject implements Login, RemoteLogin {
    private Registry registry;
    private RemoteLogin remoteLogin;

    public ClientLogin(Registry registry) throws RemoteException, NotBoundException {
        this.registry = registry;
         remoteLogin = (RemoteLogin) this.registry.lookup("login");
    }
    @Override
    public String login(String userName, String password) throws RemoteException {
      String b =  remoteLogin.login(userName,password);
      return b;
    }

    @Override
    public void close() throws IOException {

    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        ClientLogin c = new ClientLogin(LocateRegistry.getRegistry("localhost", Registry.REGISTRY_PORT));
        System.out.println( c.login("tch","222"));
    }
}
