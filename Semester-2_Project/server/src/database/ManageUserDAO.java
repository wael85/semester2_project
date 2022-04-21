package database;

import users_model.Administrator;
import users_model.Guest;
import users_model.Student;
import users_model.Teacher;

import java.sql.SQLException;

public interface ManageUserDAO {
    Administrator createAdministrator(String staffNumber, String password , String firstName , String lastName , String phone, String email ) throws SQLException;
    Guest createGuest(String CVR , String password, String companyName, String phone , String email) throws SQLException;
    Student createStudent(String studentId, String password , String firstName , String lastName ,String phone, String email) throws SQLException;
    Teacher createTeacher(String staffNumber, String password, String firstName , String lastName , String phone, String email) throws SQLException;
}
