package client;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ClientLogin extends UnicastRemoteObject implements Login{
    private Registry registry;

    public ClientLogin(Registry registry) throws RemoteException, NotBoundException {
        this.registry = registry;
    }
    @Override
    public boolean login(String userName, String password) {
        if (userName.equals("wael")){
            return true;
        }
        return false;
    }

    @Override
    public void close() throws IOException {

    }
}
