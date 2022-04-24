package sheared_interfaces;

import dk.via.remote.observer.RemotePropertyChangeListener;
import users_model.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface RemoteManageUsers extends Remote{
    Administrator createAdmin(
            String  staffNumber,String password, String firstName,
            String lastName, String phone, String email
    ) throws  RemoteException;

    Student createStudent(
            String studentId, String password, String firstName,
            String lastName, String phone, String email
    ) throws RemoteException;

    Teacher createTeacher(
            String staffNumber,String password, String firstName, String lastName,
            String phone, String email
    ) throws RemoteException;

    Guest createGuest(
            String CVR, String password, String companyName, String phone,
            String email
    ) throws RemoteException;

    Users getAllUsers() throws  RemoteException;

    Users getAllTeachers() throws RemoteException;

    Users getAllStudents() throws RemoteException;

    Users getAllAdmins() throws RemoteException;

    Users getAllGuests() throws RemoteException;

    void deleteUser(String userName) throws RemoteException;


    void addPropertyChangeListener(RemotePropertyChangeListener<Users> listener) throws RemoteException;

    void removePropertyChangeListener(RemotePropertyChangeListener<Users> listener) throws RemoteException;

}
