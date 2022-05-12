package server;

import sheared_interfaces.RemoteManageLogin;
import users_model.User;

public class ManageLoginImp implements RemoteManageLogin {
    private loginDAO loginDAO;

    @Override
    public boolean login(String userName,String password) {


        return loginDAO.loginDAO;
    }
}
