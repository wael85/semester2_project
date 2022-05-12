package database;

import users_model.User;

import java.sql.SQLException;

public interface LoginDAO {
    boolean login(String userName, String password) throws SQLException;
    User getUser(String username) throws SQLException;
}
