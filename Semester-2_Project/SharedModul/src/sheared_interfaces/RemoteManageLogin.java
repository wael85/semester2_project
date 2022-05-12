package sheared_interfaces;

import users_model.User;

import java.rmi.Remote;

public interface RemoteManageLogin extends Remote {


boolean login(String userName,String password);

}
