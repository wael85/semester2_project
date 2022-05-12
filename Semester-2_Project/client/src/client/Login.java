package client;

import java.io.Closeable;
import java.rmi.RemoteException;

public interface Login extends Closeable {
    String login(String userName,String password) throws RemoteException;
}
