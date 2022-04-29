package database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import users_model.Administrator;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ManageUserDAOTest {
    private ManageUserImp userImp;
    private Administrator admin;

    @BeforeEach
    public void setup() throws SQLException {
   userImp= new ManageUserImp();
   userImp.getConnection();
   admin=new Administrator("ww","ww","ww","ww","ww","ww");

    }
    @AfterEach
    public void clearData(){

    }
@Test
  public void createAdminTODatabase() throws SQLException {
        userImp.createAdministrator("ww","ww","ww","ww","ww","ww");
      //  assertEquals(admin,userImp.getAllAdmins());
}

}