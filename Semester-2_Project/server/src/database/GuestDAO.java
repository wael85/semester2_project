package database;

import users_model.Administrator;
import users_model.Guest;

import java.sql.SQLException;

public interface GuestDAO {
    String create(int CVR , String company_name, String email, int phone ,String password);
}
