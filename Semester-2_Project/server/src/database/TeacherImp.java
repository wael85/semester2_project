package database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherImp implements TeacherDAO {
    private static TeacherImp instance;
    private Dotenv dotenv = Dotenv.load();

    private TeacherImp() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }
    public static synchronized TeacherImp getInstance() throws SQLException{
        if (instance == null){
            instance = new TeacherImp();
        }
        return instance;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://hattie.db.elephantsql.com:5432/zvltjqzb",dotenv.get("USER_NAME"),dotenv.get("PASSWORD"));
    }

    @Override
    public String create(int staff_number, String firstName, String lastName, String email, int phone, String password){

        try(Connection connection = getConnection() ){
            PreparedStatement statement = connection.prepareStatement("insert into administrator (user_name, f_name, l_name, email, phone, password)" +
                    "values (?,?,?,?,?,?);");
            statement.setInt(1,staff_number);
            statement.setString(2,firstName);
            statement.setString(3,lastName);
            statement.setString(4,email);
            statement.setInt(5,phone);
            statement.setString(6,password);
            statement.executeUpdate();
            return staff_number + ", add successful!";
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
