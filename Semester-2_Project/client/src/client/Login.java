package client;

import java.io.Closeable;

public interface Login extends Closeable {
    boolean login(String userName,String password);
}
