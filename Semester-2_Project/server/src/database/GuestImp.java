package database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GuestImp implements GuestDAO {
    private static GuestImp instance;
    private Dotenv dotenv = Dotenv.load();

    private GuestImp() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }
    public static synchronized GuestImp getInstance() throws SQLException{
        if (instance == null){
            instance = new GuestImp();
        }
        return instance;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://hattie.db.elephantsql.com:5432/zvltjqzb",dotenv.get("USER_NAME"),dotenv.get("PASSWORD"));
    }

    @Override
    public String create(String CVR, String company_name, String email, String phone, String password) throws SQLException {

        try(Connection connection = getConnection() ){
            PreparedStatement statement = connection.prepareStatement("insert into guest (user_name, company_name, email, phone, password)" +
                    "values (?,?,?,?,?);");
            statement.setString(1,CVR);
            statement.setString(2,company_name);
            statement.setString(3,email);
            statement.setString(4,phone);
            statement.setString(5,password);
            statement.executeUpdate();

            return CVR+", add successful!";

        }
    }
}
