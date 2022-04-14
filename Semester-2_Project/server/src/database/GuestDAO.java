package database;

import java.sql.SQLException;

public interface GuestDAO {

    String create(String CVR , String companyName, String email, String phone ,String password);

}
