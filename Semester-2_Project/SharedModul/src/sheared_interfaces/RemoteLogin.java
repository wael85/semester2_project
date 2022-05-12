package sheared_interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteLogin extends Remote {
    boolean login(String userName , String password) throws RemoteException;
}
