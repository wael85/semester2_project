package database;

import users_model.Administrator;
import users_model.Guest;
import users_model.Student;
import users_model.Teacher;

import java.sql.SQLException;

public interface ManageUserDAO {
    Administrator createAdministrator(String staffNumber , String firstName , String lastName , String phone, String email , String password) throws SQLException;
    Guest createGuest(String CVR , String companyName, String phone , String email, String password) throws SQLException;
    Student createStudent(String studentId , String firstName , String lastName ,String phone, String email, String password) throws SQLException;
    Teacher createTeacher(String staffNumber, String firstName , String lastName , String phone, String email, String password) throws SQLException;
}
