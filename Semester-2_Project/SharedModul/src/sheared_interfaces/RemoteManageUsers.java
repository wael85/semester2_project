package sheared_interfaces;

import users_model.Administrator;
import users_model.Guest;
import users_model.Student;
import users_model.Teacher;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface RemoteManageUsers extends Remote {
    Administrator createAdmin(
            String  staffNumber, String firstName,
            String lastName, String phone, String email,String password
    ) throws SQLException, RemoteException;

    Student createStudent(
            String studentId, String firstName,
            String lastName, String phone, String email, String password
    ) throws SQLException,RemoteException;

    Teacher createTeacher(
            String staffNumber, String firstName, String lastName,
            String phone, String email,String password
    ) throws SQLException,RemoteException;

    Guest createGuest(
            String CVR, String companyName, String phone,
            String email, String password
    ) throws SQLException,RemoteException;

}
