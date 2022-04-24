package users_model;

import java.io.Serializable;
import java.util.ArrayList;

public class Users implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private final ArrayList<User> users;

    public Users() {
        this.users = new ArrayList<>();
    }
    public ArrayList<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();
        for (User x: users ) {
            if (x.getUserType().equals(UsersTypes.STUDENT.name())){
                students.add((Student) x);
            }
        }
        return students;
    }
    public void addUser(User user){
        users.add(user);
    }
    public void addUsers(Users users){
        this.users.addAll(users.getUsers());
    }
    public ArrayList<User> getUsers(){
        return users;
    }

    public ArrayList<Administrator> getAdministrators(){
        ArrayList<Administrator> administrators = new ArrayList<>();
        for (User x: users ) {
            if (x.getUserType().equals(UsersTypes.ADMINISTRATOR.name())){
                administrators.add((Administrator) x);
            }
        }
        return administrators;
    }
    public ArrayList<Teacher> getTeachers(){
        ArrayList<Teacher> teachers = new ArrayList<>();
        for (User x: users ) {
            if (x.getUserType().equals(UsersTypes.TEACHER.name())){
                teachers.add((Teacher) x);
            }
        }
        return teachers;
    }
    public ArrayList<Guest> getGuests(){
        ArrayList<Guest> guests = new ArrayList<>();
        for (User x: users ) {
            if (x.getUserType().equals(UsersTypes.GUEST.name())){
                guests.add((Guest) x);
            }
        }
        return guests;
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }
}
