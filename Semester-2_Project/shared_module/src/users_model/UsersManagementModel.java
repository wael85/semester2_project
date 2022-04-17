package users_model;

import java.rmi.RemoteException;
import java.sql.SQLException;

public interface UsersManagementModel {
    Administrator createAdmin(String  staffNumber, String firstName, String lastName, String phone, String email,String password) throws SQLException, RemoteException;

}
