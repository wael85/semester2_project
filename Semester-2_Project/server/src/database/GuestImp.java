package database;

import io.github.cdimascio.dotenv.Dotenv;
import users_model.Guest;

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
    public String create(int CVR, String company_name, String email, int phone, String password){

        try(Connection connection = getConnection() ){
            PreparedStatement statement = connection.prepareStatement("insert into guest (user_name, company_name, email, phone, password)" +
                    "values (?,?,?,?,?);");
            statement.setInt(1,CVR);
            statement.setString(2,company_name);
            statement.setString(3,email);
            statement.setInt(4,phone);
            statement.setString(5,password);
            statement.executeUpdate();

            return CVR+", add successful!";

        }catch (SQLException e){
            return e.getMessage();
        }
        finally {
            try {
                getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
