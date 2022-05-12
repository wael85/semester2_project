package login;

import java.io.Closeable;
import java.rmi.RemoteException;

public interface LoginModel extends Closeable {
    boolean login (String username ,String password) throws RemoteException;

}
