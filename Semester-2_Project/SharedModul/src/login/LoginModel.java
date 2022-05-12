package login;

import java.io.Closeable;

public interface LoginModel extends Closeable {
    boolean login (String username ,String password);

}
