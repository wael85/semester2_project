package server;

import users_model.Administrator;
import users_model.Guest;
import users_model.Student;
import users_model.Teacher;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface RemoteCreateUsers extends Remote {
    Administrator createAdmin(
            String  staff_number, String f_name,
            String l_name, String phone, String email,String password
    ) throws SQLException, RemoteException;

    Student createStudent(
            String student_id, String firstName,
            String last_name, String phone, String email, String password
    ) throws SQLException,RemoteException;

    Teacher createTeacher(
            String staff_number, String f_name, String l_name,
            String phone, String email,String password
    ) throws SQLException,RemoteException;

    Guest createGuest(
            String CVR, String company_name, String phone,
            String email, String password
    ) throws SQLException,RemoteException;

}
