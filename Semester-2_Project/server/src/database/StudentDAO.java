package database;

import users_model.Student;

import java.sql.SQLException;

public interface StudentDAO {
    Student create(
            int id , String firstName ,
            String lastName ,String email ,
            String tel ,String password) throws SQLException;
}
