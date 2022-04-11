package database;
import io.github.cdimascio.dotenv.Dotenv;
import users_model.Student;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
    @Override
    public Student create(
            int id, String firstName,
            String lastName, String email,
            String tel, String password)
            throws SQLException {

        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://hattie.db.elephantsql.com:5432/zvltjqzb",dotenv.get("USER_NAME"),dotenv.get("PASSWORD")) ){
            PreparedStatement statement = connection.prepareStatement("insert into via.student (student_id, f_name, l_name, email, tel, password)" +
                     "values (?,?,?,?,?,?);");
            statement.setInt(1,id);
            statement.setString(2,firstName);
            statement.setString(3,lastName);
            statement.setString(4,email);
            statement.setString(5,tel);
            statement.setString(6,password);
            statement.executeUpdate();
            return new Student(id,firstName,lastName,tel,email,password);
        }
    }

    public static void main(String[] args) throws IOException, SQLException {
       try {
           ServerSocket serverSocket = new ServerSocket(9999);
           StudentDAO student = StudentImp.getInstance();
           student.create(31777,"wael2","haed","dsfsd","2334455","sfsdfs");
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
