package server;

import database.ManageUserDAO;
import database.ManageUserImp;
import dk.via.remote.observer.RemotePropertyChangeListener;
import dk.via.remote.observer.RemotePropertyChangeSupport;
import sheared_interfaces.RemoteManageUsers;
import users_model.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class ManageUsersServerImp extends UnicastRemoteObject implements RemoteManageUsers {
    private final ManageUserDAO manageUserDAO;
    private final RemotePropertyChangeSupport<Users> support;

    public ManageUsersServerImp() throws RemoteException, SQLException {
        manageUserDAO = ManageUserImp.getInstance();
        this.support = new RemotePropertyChangeSupport<>(this);
    }

    @Override
    public Administrator createAdmin(String staffNumber, String password, String firstName, String lastName, String phone, String email) throws RemoteException{
         try {
             Administrator administrator = manageUserDAO.createAdministrator(staffNumber, password, firstName, lastName, phone, email);
            support.firePropertyChange("users",null,manageUserDAO.getAllUsers());
            return administrator;
         }catch (SQLException ex){
             throw new RemoteException(ex.getMessage(),ex);
         }
    }

    @Override
    public Student createStudent(String studentId, String password, String firstName, String lastName, String phone, String email) throws RemoteException {
        try {
           Student student = manageUserDAO.createStudent(studentId, password, firstName, lastName, phone, email);
            support.firePropertyChange("users",null,manageUserDAO.getAllUsers());
            return student;
        }catch (SQLException ex){
            throw new RemoteException(ex.getMessage(),ex);
        }
    }

    @Override
    public Teacher createTeacher(String staffNumber, String password, String firstName, String lastName, String phone, String email) throws RemoteException {
      try {
          Teacher teacher = manageUserDAO.createTeacher(staffNumber, password, firstName, lastName, phone, email);
          support.firePropertyChange("users",null,manageUserDAO.getAllUsers());
          return teacher;
      }catch (SQLException ex){
        throw new RemoteException(ex.getMessage(),ex);
      }
    }

    @Override
    public Guest createGuest(String CVR, String password, String companyName, String phone, String email) throws RemoteException {
        try {
           Guest guest = manageUserDAO.createGuest(CVR, password, companyName, phone, email);
            support.firePropertyChange("users",null,manageUserDAO.getAllUsers());
            return guest;

        }catch (SQLException ex){
            throw  new RemoteException(ex.getMessage(),ex);
        }
    }

    @Override
    public Users getAllUsers() throws RemoteException {
        try {
            return manageUserDAO.getAllUsers();
        }catch (SQLException ex){
            throw  new RemoteException(ex.getMessage(),ex);
        }
    }

    @Override
    public Users getAllTeachers() throws RemoteException {
        try {
            return manageUserDAO.getAllTeachers();
        }catch (SQLException ex){
            throw  new RemoteException(ex.getMessage(),ex);
        }
    }

    @Override
    public Users getAllStudents() throws RemoteException {
        try {
            return manageUserDAO.getAllStudents();
        }catch (SQLException ex){
            throw  new RemoteException(ex.getMessage(),ex);
        }
    }

    @Override
    public Users getAllAdmins() throws RemoteException {
        try {
            return manageUserDAO.getAllAdmins();
        }catch (SQLException ex){
            throw  new RemoteException(ex.getMessage(),ex);
        }
    }

    @Override
    public Users getAllGuests() throws RemoteException {
        try {
            return manageUserDAO.getAllGuests();
        }catch (SQLException ex){
            throw  new RemoteException(ex.getMessage(),ex);
        }
    }

    @Override
    public void deleteUser(String userName) throws RemoteException {
        try {
            manageUserDAO.deleteUser(userName);
            support.firePropertyChange("users",null,manageUserDAO.getAllUsers());
        }catch (SQLException ex){
            throw new RemoteException(ex.getMessage(), ex);
        }
    }

    @Override
    public void addPropertyChangeListener(RemotePropertyChangeListener<Users> listener) throws RemoteException {
           support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(RemotePropertyChangeListener<Users> listener) throws RemoteException {
          support.removePropertyChangeListener(listener);
    }
}
