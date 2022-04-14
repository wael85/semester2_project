package database;

import java.sql.SQLException;

public interface StudentDAO {
    String create(String student_id , String firstName , String lastName ,String email , String phone ,String password) throws SQLException;
}
