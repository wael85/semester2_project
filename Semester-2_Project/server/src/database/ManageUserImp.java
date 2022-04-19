package database;

import io.github.cdimascio.dotenv.Dotenv;
import users_model.Administrator;
import users_model.Guest;
import users_model.Student;
import users_model.Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManageUserImp implements ManageUserDAO{
    private static ManageUserImp instance;
    private Dotenv dotenv = Dotenv.load();

    private ManageUserImp() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }
    public static synchronized ManageUserImp getInstance() throws SQLException{
        if (instance == null){
            instance = new ManageUserImp();
        }
        return instance;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://hattie.db.elephantsql.com:5432/zvltjqzb",dotenv.get("USER_NAME"),dotenv.get("PASSWORD"));
    }

    @Override
    public Administrator createAdministrator(String staffNumber, String firstName, String lastName, String phone, String email, String password) throws SQLException {
        try(Connection connection = getConnection() ){
            PreparedStatement statement = connection.prepareStatement("insert into booking_room_system.administrator (user_name, f_name, l_name, email, phone, password)" +
                    "values (?,?,?,?,?,?);");
            statement.setString(1,staffNumber);
            statement.setString(2,firstName);
            statement.setString(3,lastName);
            statement.setString(4,email);
            statement.setString(5,phone);
            statement.setString(6,password);
            statement.executeUpdate();
            return new Administrator(staffNumber, firstName, lastName, phone, email, password);
        }
    }

    @Override
    public Guest createGuest(String CVR, String companyName, String phone, String email, String password) throws SQLException {
        try(Connection connection = getConnection() ){
            PreparedStatement statement = connection.prepareStatement("insert into booking_room_system.guest (user_name, company_name, email, phone, password)" +
                    "values (?,?,?,?,?);");
            statement.setString(1,CVR);
            statement.setString(2,companyName);
            statement.setString(3,email);
            statement.setString(4,phone);
            statement.setString(5,password);
            statement.executeUpdate();

            return new Guest(CVR, companyName, phone, email, password);
        }
    }

    @Override
    public Student createStudent(String studentId, String firstName, String lastName, String email, String phone, String password) throws SQLException {
        try(Connection connection = getConnection() ){
            PreparedStatement statement = connection.prepareStatement("insert into booking_room_system.student (user_name, f_name, l_name, email, phone, password)" +
                    "values (?,?,?,?,?,?);");
            statement.setString(1,studentId);
            statement.setString(2,firstName);
            statement.setString(3,lastName);
            statement.setString(4,email);
            statement.setString(5,phone);
            statement.setString(6,password);
            statement.executeUpdate();
            return new Student(studentId, firstName, lastName, phone, email, password);
        }
    }

    @Override
    public Teacher createTeacher(String staffNumber, String firstName, String lastName, String phone, String email, String password) throws SQLException {
        try(Connection connection = getConnection() ){
            PreparedStatement statement = connection.prepareStatement("insert into booking_room_system.teacher (user_name, f_name, l_name, email, phone, password)" +
                    "values (?,?,?,?,?,?);");
            statement.setString(1,staffNumber);

            statement.setString(2,firstName);
            statement.setString(3,lastName);
            statement.setString(4,email);
            statement.setString(5,phone);
            statement.setString(6,password);
            statement.executeUpdate();
            return new Teacher(staffNumber, firstName, lastName, phone, email, password);
        }
    }
}
