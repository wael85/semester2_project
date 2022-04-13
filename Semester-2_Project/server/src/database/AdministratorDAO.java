package database;

import users_model.Administrator;

import java.sql.SQLException;

public interface AdministratorDAO {
    String create(int Staff_number , String firstName , String lastName ,String email ,int phone ,String password);
}
