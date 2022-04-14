package database;

public interface TeacherDAO {
    String create(int Staff_number, String firstName , String lastName ,String email ,int phone ,String password);
}
