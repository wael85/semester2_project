package database;

public interface StudentDAO {
    String create(int student_id , String firstName , String lastName ,String email , int phone ,String password);
}
