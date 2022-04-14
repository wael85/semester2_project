package database;

import java.sql.SQLException;

public interface TeacherDAO {
    String create(String Staff_number, String firstName , String lastName ,String email ,String phone ,String password) throws SQLException;
}
