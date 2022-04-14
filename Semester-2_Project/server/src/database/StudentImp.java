package database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentImp implements StudentDAO{
    private static StudentImp instance;
    private Dotenv dotenv = Dotenv.load();

    private StudentImp() throws SQLException{
        DriverManager.registerDriver(new org.postgresql.Driver());
    }
    public static synchronized StudentImp getInstance() throws SQLException{
        if (instance == null){
            instance = new StudentImp();
        }
        return instance;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://hattie.db.elephantsql.com:5432/zvltjqzb",dotenv.get("USER_NAME"),dotenv.get("PASSWORD"));
    }
    @Override
    public String create(String studentId, String firstName, String lastName, String email, String phone, String password) {

        try(Connection connection = getConnection() ){
            PreparedStatement statement = connection.prepareStatement("insert into student (user_name, f_name, l_name, email, phone, password)" +
                     "values (?,?,?,?,?,?);");
            statement.setString(1,studentId);
            statement.setString(2,firstName);
            statement.setString(3,lastName);
            statement.setString(4,email);
            statement.setString(5,phone);
            statement.setString(6,password);
            statement.executeUpdate();
            return studentId+ ", add successful!";
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
