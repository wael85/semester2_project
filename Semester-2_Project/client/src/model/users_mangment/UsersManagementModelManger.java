package model.users_mangment;

import client.ManageUserClientInterface;
import model.users_mangment.UsersManagementModel;
import users_model.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.rmi.RemoteException;

public class UsersManagementModelManger  implements UsersManagementModel {
    private ManageUserClientInterface client;
    private PropertyChangeSupport support;

    public UsersManagementModelManger(ManageUserClientInterface client) throws RemoteException{
        this.client = client;
        support = new PropertyChangeSupport(this);
        client.addPropertyChangeListener("users", evt -> {
             updateUserList(evt);
        });

    }


    @Override
    public Administrator createAdmin(String staffNumber, String firstName, String lastName, String phone, String email, String password) throws  RemoteException {
       return   client.createAdmin(staffNumber,firstName,lastName,phone,email,password);
    }

    @Override
    public Student createStudent(String studentId, String firstName, String lastName, String phone, String email, String password) throws  RemoteException {
      return   client.createStudent(studentId, firstName, lastName, phone, email, password);
    }

    @Override
    public Teacher createTeacher(String staffNumber, String firstName, String lastName, String phone, String email, String password) throws  RemoteException {
      return    client.createTeacher(staffNumber, firstName, lastName, phone, email, password);
    }

    @Override
    public Guest createGuest(String CVR, String companyName, String phone, String email, String password) throws RemoteException {
        return client.createGuest(CVR, companyName, phone, email, password);
    }

    @Override
    public void addPropertyChangeListener(String evt, PropertyChangeListener listener) {
            support.addPropertyChangeListener(evt ,listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
          support.removePropertyChangeListener(listener);
    }
    public void updateUserList(PropertyChangeEvent event){
       support.firePropertyChange("users", null,event.getNewValue());
    }
    @Override
    public Users getAllUsers() throws RemoteException {
        return client.getAllUsers();
    }

    @Override
    public void deleteUser(String userName) throws RemoteException {
        client.deleteUser(userName);
    }

    @Override
    public void close() throws IOException {
        client.close();
    }
}
