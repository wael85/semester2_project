package database;

public interface GuestDAO {
    String create(String CVR , String companyName, String email, String phone ,String password);
}
