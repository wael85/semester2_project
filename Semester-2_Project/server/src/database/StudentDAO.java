package database;

import java.sql.SQLException;

public interface StudentDAO {
    String create(String studentId , String firstName , String lastName ,String email , String phone ,String password);

}
