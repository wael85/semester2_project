package client;

import sheared_interfaces.RemoteManageUsers;
import users_model.Administrator;
import users_model.Guest;
import users_model.Student;
import users_model.Teacher;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class ManageUserClient extends UnicastRemoteObject implements ManageUserClientInterface {
    private RemoteManageUsers remoteManageUsers;

    public ManageUserClient(String host , int port) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(host,port);
        remoteManageUsers = (RemoteManageUsers) registry.lookup("create_users");
    }

    @Override
    public void close() throws IOException {
        UnicastRemoteObject.unexportObject(this,true);
    }

    @Override
    public Administrator createAdmin(String staffNumber, String firstName, String lastName, String phone, String email, String password) throws SQLException, RemoteException {
        try {

            return remoteManageUsers.createAdmin(staffNumber, firstName, lastName,phone,email,password);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student createStudent(String studentId, String firstName, String lastName, String phone, String email, String password) throws SQLException, RemoteException {
        return remoteManageUsers.createStudent(studentId,firstName,lastName,phone,email,password);
    }

    @Override
    public Teacher createTeacher(String staffNumber, String firstName, String lastName, String phone, String email, String password) throws SQLException, RemoteException {
        return remoteManageUsers.createTeacher(staffNumber,firstName,lastName,phone,email,password);
    }

    @Override
    public Guest createGuest(String CVR, String companyName, String phone, String email, String password) throws SQLException, RemoteException {
        return remoteManageUsers.createGuest(CVR,companyName,phone,email,password);
    }
}
