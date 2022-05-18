package database;

import users_model.*;

import java.sql.SQLException;

public interface ManageUserDAO {
    Administrator createAdministrator(String staffNumber, String password, String firstName, String lastName, String email, String phone) throws SQLException;

    Guest createGuest(String CVR, String password, String companyName, String email, String phone) throws SQLException;

    Student createStudent(String studentId, String password, String firstName, String lastName, String email, String phone) throws SQLException;

    Teacher createTeacher(String staffNumber, String password, String firstName, String lastName, String email, String phone) throws SQLException;

    void deleteUser(String userName) throws SQLException;

    Users getAllUsers() throws SQLException;

    Users getAllStudents() throws SQLException;

    Users getAllTeachers() throws SQLException;

    Users getAllAdmins() throws SQLException;

    Users getAllGuests() throws SQLException;
}
