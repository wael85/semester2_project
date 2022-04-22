package users_model;

import client.ManageUserClientInterface;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class UsersManagementModelManger implements UsersManagementModel{
    private ManageUserClientInterface client;

    public UsersManagementModelManger(ManageUserClientInterface client){
        this.client = client;
    }


    @Override
    public Administrator createAdmin(String staffNumber, String firstName, String lastName, String phone, String email, String password) throws SQLException, RemoteException {
        return client.createAdmin(staffNumber,firstName,lastName,phone,email,password);
    }

    @Override
    public Student createStudent(String studentId, String firstName, String lastName, String phone, String email, String password) throws SQLException, RemoteException {
        return client.createStudent(studentId, firstName, lastName, phone, email, password);
    }

    @Override
    public Teacher createTeacher(String staffNumber, String firstName, String lastName, String phone, String email, String password) throws SQLException, RemoteException {
        return client.createTeacher(staffNumber, firstName, lastName, phone, email, password);
    }

    @Override
    public Guest createGuest(String CVR, String companyName, String phone, String email, String password) throws SQLException, RemoteException {
        return client.createGuest(CVR, companyName, phone, email, password);
    }

    @Override
    public void close() throws IOException {
        client.close();
    }
}
