package users_model;

import java.io.Serializable;

public abstract class User implements Serializable {
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return
                "userName: " + userName +
                ", password: " + password;
    }
}
