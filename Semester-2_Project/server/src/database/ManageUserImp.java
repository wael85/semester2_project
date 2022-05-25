package database;

import io.github.cdimascio.dotenv.Dotenv;
import users_model.*;

import java.sql.*;

public class ManageUserImp implements ManageUserDAO{
    private static ManageUserImp instance;
    private Dotenv dotenv = Dotenv.load();

   ManageUserImp() throws SQLException {
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
      //return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","369968");

     //return DriverManager.getConnection("jdbc:postgresql://localhost:5432/sep2_project?currentSchema=booking_room_system","postgres","1230");
    }

    @Override
    public Administrator createAdministrator(String staffNumber, String password, String firstName, String lastName, String email, String phone) throws SQLException {
        try(Connection connection = getConnection() ){
            PreparedStatement statement = connection.prepareStatement("insert into booking_room_system.users (user_name, password)\n" +
                    "values (?,?);\n" +
                    "\n" +
                    "insert into booking_room_system.administrator (user_name_fk, f_name, l_name, email, phone)\n" +
                    "values (?,?,?,?,?);");
            statement.setString(1,staffNumber);
            statement.setString(2,password);
            statement.setString(3,staffNumber);
            statement.setString(4,firstName);
            statement.setString(5,lastName);
            statement.setString(6,email);
            statement.setString(7,phone);
            statement.executeUpdate();
            return new Administrator(staffNumber,password,firstName,lastName,email,phone);
        }
    }

    @Override
    public Guest createGuest(String CVR, String password, String companyName, String email, String phone) throws SQLException {
        try(Connection connection = getConnection() ){
            PreparedStatement statement = connection.prepareStatement("insert into booking_room_system.users (user_name,password)\n"+"values(?,?);\n"+"insert into booking_room_system.guest ( user_name_fk,company_name, email, phone)\n" +
                    "values (?,?,?,?);");
            statement.setString(1,CVR);
            statement.setString(2,password);
            statement.setString(3,CVR);
            statement.setString(4,companyName);
            statement.setString(5,email);
            statement.setString(6,phone);
            statement.executeUpdate();
            return new Guest(CVR,password,companyName,email,phone);
        }
    }

    @Override
    public Student createStudent(String studentId, String password, String firstName, String lastName, String email, String phone) throws SQLException {
        try(Connection connection = getConnection() ){
            PreparedStatement statement = connection.prepareStatement("insert into booking_room_system.users (user_name,password)\n"+"values(?,?);\n"+"insert into booking_room_system.student (user_name_fk, f_name, l_name, email, phone)" +
                    "values (?,?,?,?,?);");
            statement.setString(1,studentId);
            statement.setString(2,password);
            statement.setString(3,studentId);
            statement.setString(4,firstName);
            statement.setString(5,lastName);
            statement.setString(6,email);
            statement.setString(7,phone);
            statement.executeUpdate();
            return new Student(studentId,password,firstName,lastName,email,phone);
        }
    }

    @Override
    public Teacher createTeacher(String staffNumber, String password, String firstName, String lastName, String email, String phone) throws SQLException {
        try(Connection connection = getConnection() ){
            PreparedStatement statement = connection.prepareStatement("insert into booking_room_system.users (user_name,password)\n"+"values(?,?);\n"+"insert into booking_room_system.teacher (user_name_fk, f_name, l_name, email, phone)" +
                    "values (?,?,?,?,?);");
            statement.setString(1,staffNumber);

            statement.setString(2,password);
            statement.setString(3,staffNumber);
            statement.setString(4,firstName);
            statement.setString(5,lastName);
            statement.setString(6,email);
            statement.setString(7,phone);
            statement.executeUpdate();
            return new Teacher(staffNumber,password,firstName,lastName,email,phone);
        }
    }

    @Override
    public void deleteUser(String userName) throws SQLException{
        try(Connection c = getConnection()) {
            PreparedStatement preparedStatement = c.prepareStatement("delete\n" +
                    "from booking_room_system.users\n" +
                    "where user_name = ?;");
            preparedStatement.setString(1,userName);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Users getAllUsers()throws SQLException{
        Users users = new Users();
        users.addUsers(getAllAdmins());
        users.addUsers(getAllGuests());
        users.addUsers(getAllStudents());
        users.addUsers(getAllTeachers());
        return users;
    }

    @Override
    public Users getAllStudents() throws SQLException {
        Users users = new Users();
        try (Connection c = getConnection()) {
            PreparedStatement preparedStatement = c.prepareStatement("select user_name,password,student.f_name,student.l_name ,student.email,student.phone from booking_room_system.users join booking_room_system.student\n" +
                    "on users.user_name = student.user_name_fk");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User student = new Student(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
                users.addUser(student);
            }
            return users;
        }
    }

    @Override
    public Users getAllTeachers() throws SQLException {
        Users users = new Users();
        try (Connection c = getConnection()){
            PreparedStatement preparedStatement = c.prepareStatement("select user_name,password,teacher.f_name,teacher.l_name ,teacher.email,teacher.phone from booking_room_system.users join booking_room_system.teacher  on users.user_name = teacher.user_name_fk");
            ResultSet resultSet1 =  preparedStatement.executeQuery();
            while (resultSet1.next()){
                User teacher = new Teacher(resultSet1.getString(1),
                        resultSet1.getString(2),
                        resultSet1.getString(3),
                        resultSet1.getString(4),
                        resultSet1.getString(5),
                        resultSet1.getString(6)
                );
                users.addUser(teacher);
            }
            return users;

        }
    }

    @Override
    public Users getAllAdmins() throws SQLException {
        Users users = new Users();
        try (Connection c = getConnection()) {
            PreparedStatement preparedStatement = c.prepareStatement("select user_name,password," +
                    "administrator.f_name,administrator.l_name" +
                    " ,administrator.email,administrator.phone from booking_room_system.users " +
                    "join booking_room_system.administrator  " +
                    "on users.user_name = administrator.user_name_fk");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User admin = new Administrator(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
                users.addUser(admin);
            }
            return users;
        }
    }

    @Override
    public Users getAllGuests() throws SQLException {
        Users users = new Users();
        try (Connection c = getConnection()) {
            PreparedStatement preparedStatement = c.prepareStatement("select user_name,password,guest.company_name," +
                    "guest.phone ,guest.email from booking_room_system.users " +
                    "join booking_room_system.guest  on" +
                    " users.user_name = guest.user_name_fk");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User guest = new Guest(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
                users.addUser(guest);
            }
            return users;
        }
    }
}
