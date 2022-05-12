package client;

import java.io.Closeable;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface Login extends Closeable {
    Boolean login(String userName, String password) throws RemoteException, SQLException;
}
