package users_model;

import clients_classes.ManageUserClientInterface;

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
}
