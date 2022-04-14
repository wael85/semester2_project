package database;

import java.sql.SQLException;

public interface AdministratorDAO {
    String create(String StaffNumber , String firstName , String lastName ,String email ,String phone ,String password);

}
