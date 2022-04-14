package database;

import java.sql.SQLException;

public interface GuestDAO {
    String create(String CVR , String company_name, String email, String phone ,String password) throws SQLException;
}
