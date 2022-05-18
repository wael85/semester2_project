package model.users_mangment;
import users_model.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Closeable;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface UsersManagementModel extends Closeable  {
    Administrator createAdmin(String staffNumber, String password, String firstName, String lastName, String email, String phone) throws  RemoteException;

    Student createStudent(String studentId, String password, String firstName, String lastName, String phone, String email) throws  RemoteException;

    Teacher createTeacher(String staffNumber, String password, String firstName, String lastName, String phone, String email) throws  RemoteException;

    Guest createGuest(String CVR, String password, String companyName, String phone, String email) throws  RemoteException;

    void addPropertyChangeListener (String evt , PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);

    Users getAllUsers() throws RemoteException;
    void deleteUser(String userName) throws RemoteException;


}
