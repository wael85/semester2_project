package clients_classes;

import sheared_interfaces.RemoteCreateUsers;
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

public class CreateUserClient extends UnicastRemoteObject implements CreateUserClientInterface {
    private RemoteCreateUsers remoteCreateUsers;

    protected CreateUserClient(String host , int port) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(host,port);
        remoteCreateUsers = (RemoteCreateUsers) registry.lookup("create_users");
    }

    @Override
    public void close() throws IOException {
        UnicastRemoteObject.unexportObject(this,true);
    }

    @Override
    public Administrator createAdmin(String staff_number, String f_name, String l_name, String phone, String email, String password) throws SQLException, RemoteException {
        return remoteCreateUsers.createAdmin(staff_number,f_name,l_name,phone,email,password);
    }

    @Override
    public Student createStudent(String student_id, String firstName, String last_name, String phone, String email, String password) throws SQLException, RemoteException {
        return null;
    }

    @Override
    public Teacher createTeacher(String staff_number, String f_name, String l_name, String phone, String email, String password) throws SQLException, RemoteException {
        return null;
    }

    @Override
    public Guest createGuest(String CVR, String company_name, String phone, String email, String password) throws SQLException, RemoteException {
        return null;
    }
}
