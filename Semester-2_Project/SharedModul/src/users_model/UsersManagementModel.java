package users_model;

import users_model.Administrator;
import users_model.Guest;
import users_model.Student;
import users_model.Teacher;

import java.io.Closeable;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface UsersManagementModel extends Closeable {
    Administrator createAdmin(String staffNumber, String password, String firstName, String lastName, String phone, String email) throws SQLException, RemoteException;

    Student createStudent(String studentId, String password, String firstName, String lastName, String phone, String email) throws SQLException, RemoteException;

    Teacher createTeacher(String staffNumber, String password, String firstName, String lastName, String phone, String email) throws SQLException, RemoteException;

    Guest createGuest(String CVR, String password, String companyName, String phone, String email) throws SQLException, RemoteException;
}
