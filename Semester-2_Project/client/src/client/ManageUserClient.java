package client;

import dk.via.remote.observer.RemotePropertyChangeEvent;
import dk.via.remote.observer.RemotePropertyChangeListener;
import sheared_interfaces.RemoteManageUsers;
import users_model.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ManageUserClient extends UnicastRemoteObject implements ManageUserClientInterface , RemoteManageUsers ,RemotePropertyChangeListener<Users>{
    private final RemoteManageUsers remoteManageUsers;
    private final PropertyChangeSupport support;

    public ManageUserClient(Registry registry) throws RemoteException, NotBoundException {

        remoteManageUsers = (RemoteManageUsers) registry.lookup("manage_users");
       // remoteManageUsers.addPropertyChangeListener(this);
        this.support = new PropertyChangeSupport(this);
    }

    @Override
    public void close() throws IOException {
        remoteManageUsers.removePropertyChangeListener(this);
        UnicastRemoteObject.unexportObject(this,true);
    }

    @Override
    public Administrator createAdmin(String staffNumber,  String password,String firstName, String lastName, String email, String phone) throws RemoteException {
       return remoteManageUsers.createAdmin(staffNumber,password,firstName,lastName,email,phone);
    }

    @Override
    public Student createStudent(String studentId, String password, String firstName, String lastName, String email, String phone) throws RemoteException {
       return remoteManageUsers.createStudent(studentId,password,firstName,lastName,email,phone);
    }

    @Override
    public Teacher createTeacher(String staffNumber, String password, String firstName, String lastName, String email, String phone) throws  RemoteException {
       return remoteManageUsers.createTeacher(staffNumber,password,firstName,lastName,email,phone);
    }

    @Override
    public Guest createGuest(String CVR, String password, String companyName, String email, String phone) throws RemoteException {
       return remoteManageUsers.createGuest(CVR,password,companyName,email,phone);
    }

    @Override
    public Users getAllUsers() throws RemoteException {
        return remoteManageUsers.getAllUsers();
    }

    @Override
    public Users getAllTeachers() throws RemoteException {
        return remoteManageUsers.getAllTeachers();
    }

    @Override
    public Users getAllStudents() throws RemoteException {
        return remoteManageUsers.getAllStudents();
    }

    @Override
    public Users getAllAdmins() throws RemoteException {
        return remoteManageUsers.getAllAdmins();
    }

    @Override
    public Users getAllGuests() throws RemoteException {
        return remoteManageUsers.getAllGuests();
    }

    @Override
    public void deleteUser(String userName) throws RemoteException {
         remoteManageUsers.deleteUser(userName);
    }

    // no use for it
    @Override
    public void addPropertyChangeListener(RemotePropertyChangeListener<Users> listener) throws RemoteException {

    }
    // no use for it
    @Override
    public void removePropertyChangeListener(RemotePropertyChangeListener<Users> listener) throws RemoteException {
    }

    @Override
    public void addPropertyChangeListener(String event, PropertyChangeListener listener) {
        support.addPropertyChangeListener(event,listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public void propertyChange(RemotePropertyChangeEvent remotePropertyChangeEvent) throws RemoteException {
        support.firePropertyChange(remotePropertyChangeEvent.getPropertyName(),
                remotePropertyChangeEvent.getOldValue(),remotePropertyChangeEvent.getNewValue());
    }
}
