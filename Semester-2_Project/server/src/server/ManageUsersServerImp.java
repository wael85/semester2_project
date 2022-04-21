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
    private ManageUserDAO manageUserDAO;

    public ManageUsersServerImp() throws RemoteException, SQLException {
        manageUserDAO = ManageUserImp.getInstance();
    }

    @Override
    public Administrator createAdmin(String staffNumber, String password, String firstName, String lastName, String phone, String email) throws RemoteException,SQLException {
        return manageUserDAO.createAdministrator(staffNumber, password, firstName, lastName, phone, email);
    }

    @Override
    public Student createStudent(String studentId, String password, String firstName, String lastName, String phone, String email) throws RemoteException,SQLException {
       return manageUserDAO.createStudent(studentId, password, firstName, lastName, phone, email);
    }

    @Override
    public Teacher createTeacher(String staffNumber, String password, String firstName, String lastName, String phone, String email) throws RemoteException,SQLException {
        return manageUserDAO.createTeacher(staffNumber, password, firstName, lastName, phone, email);
    }

    @Override
    public Guest createGuest(String CVR, String password, String companyName, String phone, String email) throws RemoteException ,SQLException {
        return manageUserDAO.createGuest(CVR, password, companyName, phone, email);
    }
}
