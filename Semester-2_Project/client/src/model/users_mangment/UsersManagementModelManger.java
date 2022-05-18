package model.users_mangment;

import client.ManageUserClientInterface;
import model.inputValidation.ValidatorManageUsers;
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
    public Administrator createAdmin(String staffNumber, String password, String firstName, String lastName, String email, String phone) throws  RemoteException {
        ValidatorManageUsers.validatorCreateAdmin(staffNumber, password, firstName, lastName, email, phone);

       return   client.createAdmin(staffNumber,password,firstName,lastName,email,phone);
    }

    @Override
    public Student createStudent(String studentId, String password, String firstName, String lastName, String email, String phone) throws  RemoteException {

        ValidatorManageUsers.validatorCreateStudent(studentId, password, firstName, lastName, email, phone);
      return   client.createStudent(studentId, password, firstName, lastName, email, phone);
    }

    @Override
    public Teacher createTeacher(String staffNumber, String password, String firstName, String lastName, String email, String phone) throws  RemoteException {
     ValidatorManageUsers.validatorCreateTeacher(staffNumber, password, firstName, lastName, email, phone);
      return    client.createTeacher(staffNumber, password, firstName, lastName, email, phone);
    }

    @Override
    public Guest createGuest(String CVR, String password, String companyName, String email, String phone) throws RemoteException {
        ValidatorManageUsers.validatorCreateGuest(CVR, password, companyName, email, phone);
        return client.createGuest(CVR, password, companyName, email, phone);
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
