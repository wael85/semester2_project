package database;

import users_model.*;

import java.sql.SQLException;

public interface ManageUserDAO {
    Administrator createAdministrator(String staffNumber, String password , String firstName , String lastName , String phone, String email ) throws SQLException;
    Guest createGuest(String CVR , String password, String companyName, String phone , String email) throws SQLException;
    Student createStudent(String studentId, String password , String firstName , String lastName ,String phone, String email) throws SQLException;
    Teacher createTeacher(String staffNumber, String password, String firstName , String lastName , String phone, String email) throws SQLException;
    void deleteUser(String userName) throws SQLException;
    Users getAllUsers() throws  SQLException;
    Users getAllStudents() throws SQLException;
    Users getAllTeachers() throws SQLException;
    Users getAllAdmins() throws SQLException;
    Users getAllGuests() throws SQLException;
}
