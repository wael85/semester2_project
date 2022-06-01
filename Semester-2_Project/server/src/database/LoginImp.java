package database;

import io.github.cdimascio.dotenv.Dotenv;
import users_model.*;

import java.sql.*;

public class LoginImp implements LoginDAO {

    private static LoginImp instance;
    private Dotenv dotenv = Dotenv.load();


    private LoginImp() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized LoginImp getInstance() throws SQLException {
        if (instance == null) {
            instance = new LoginImp();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://hattie.db.elephantsql.com:5432/zvltjqzb",
                dotenv.get("USER_NAME"), dotenv.get("PASSWORD"));
    }


    @Override
    public boolean login(String userName, String password) throws SQLException {
        boolean check = false;
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM booking_room_system.users WHERE user_name = ? AND password = ?");
            statement.setString(1, userName);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String password1 = resultSet.getString(2);
                if (name != null) {
                    check = true;
                } else {
                    check = false;
                }
            }
        }
        return check;
    }


    @Override
    public User getUser(String username) throws SQLException {
        try (Connection c = getConnection()) {
            PreparedStatement statement = c.prepareStatement("SELECT * FROM booking_room_system.administrator WHERE user_name_fk = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String f_name = resultSet.getString(2);
                String l_name = resultSet.getString(3);
                String phone = resultSet.getString(4);
                String email = resultSet.getString(5);
                if (name != null) {
                    return new Administrator(name,null, f_name, l_name, phone, email);
                }
            }
            PreparedStatement statement2 = c.prepareStatement("SELECT * FROM booking_room_system.student WHERE user_name_fk = ?");
            statement2.setString(1, username);
            ResultSet resultSet2 = statement2.executeQuery();
            while (resultSet2.next()) {
                String name1 = resultSet2.getString(1);
                String f_name1 = resultSet2.getString(2);
                String l_name1 = resultSet2.getString(3);
                String phone1 = resultSet2.getString(4);
                String email1 = resultSet2.getString(5);
                if (name1 != null) {
                    return new Student(name1, null, f_name1, l_name1, phone1, email1);
                }
            }
            PreparedStatement statement3 = c.prepareStatement("SELECT * FROM booking_room_system.teacher WHERE user_name_fk = ?");
            statement3.setString(1, username);
            ResultSet resultSet3 = statement3.executeQuery();
            while (resultSet3.next()) {
                String name1 = resultSet3.getString(1);
                String f_name1 = resultSet3.getString(2);
                String l_name1 = resultSet3.getString(3);
                String phone1 = resultSet3.getString(4);
                String email1 = resultSet3.getString(5);
                if (name1 != null) {
                    return new Teacher(name1, null, f_name1, l_name1, phone1, email1);
                }
            }
            PreparedStatement statement4 = c.prepareStatement("SELECT * FROM booking_room_system.guest WHERE user_name_fk = ?");
            statement4.setString(1, username);
            ResultSet resultSet4 = statement4.executeQuery();
            while (resultSet4.next()) {
                String name1 = resultSet4.getString(1);
                String companyName = resultSet4.getString(2);
                String phone1 = resultSet4.getString(3);
                String email1 = resultSet4.getString(4);
                if (name1 != null) {
                    return new Guest(name1, null, companyName, phone1, email1);
                }
            }
        }
        return null;
    }

}
