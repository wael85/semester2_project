package server;

import users_model.Administrator;
import users_model.Guest;
import users_model.Student;
import users_model.Teacher;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class CreateUsersImp extends UnicastRemoteObject implements RemoteCreateUsers {


    public CreateUsersImp() throws RemoteException {
    }

    @Override
    public Administrator createAdmin(String staff_number, String f_name, String l_name, String phone, String email, String password) throws RemoteException,SQLException {
        return null;
    }

    @Override
    public Student createStudent(String student_id, String firstName, String last_name, String phone, String email, String password) throws RemoteException,SQLException {
        return null;
    }

    @Override
    public Teacher createTeacher(String staff_number, String f_name, String l_name, String phone, String email, String password) throws RemoteException,SQLException {
        return null;
    }

    @Override
    public Guest createGuest(String CVR, String company_name, String phone, String email, String password) throws RemoteException ,SQLException {
        return null;
    }
}
