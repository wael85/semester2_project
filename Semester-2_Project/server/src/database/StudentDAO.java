package database;

import users_model.Student;

import java.sql.SQLException;

public interface StudentDAO {
    String create(int student_id , String firstName , String lastName ,String email , int phone ,String password);
}
