package server;

import database.ManageUserDAO;
import database.ManageUserImp;
import sheared_interfaces.RemoteManageUsers;
import users_model.Administrator;
import users_model.Guest;
import users_model.Student;
import users_model.Teacher;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class ManageUsersServerImp extends UnicastRemoteObject implements RemoteManageUsers {
    ManageUserDAO manageUserDAO= ManageUserImp.getInstance();

    public ManageUsersServerImp() throws RemoteException, SQLException {
    }

    @Override
    public Administrator createAdmin(String staffNumber, String firstName, String lastName, String phone, String email, String password) throws RemoteException,SQLException {
        return manageUserDAO.createAdministrator(staffNumber, firstName, lastName, phone, email, password);
    }

    @Override
    public Student createStudent(String studentId, String firstName, String lastName, String phone, String email, String password) throws RemoteException,SQLException {
       return manageUserDAO.createStudent(studentId, firstName, lastName, phone, email, password);
    }

    @Override
    public Teacher createTeacher(String staffNumber, String firstName, String lastName, String phone, String email, String password) throws RemoteException,SQLException {
        return manageUserDAO.createTeacher(staffNumber, firstName, lastName, phone, email, password);
    }

    @Override
    public Guest createGuest(String CVR, String companyName, String phone, String email, String password) throws RemoteException ,SQLException {
        return manageUserDAO.createGuest(CVR, companyName, phone, email, password);
    }
}
