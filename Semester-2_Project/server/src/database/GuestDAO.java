package database;

public interface GuestDAO {
    String create(int CVR , String company_name, String email, int phone ,String password);
}
