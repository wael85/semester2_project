package sheared_interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface RemoteLogin extends Remote {
    Boolean login(String userName , String password) throws RemoteException, SQLException;
}
