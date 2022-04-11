package users_model;

public class Student {
    public int id;
    public String firstName;
    public String last_name;
    public String tel;
    public String email;
    public String password;

    public Student(int id, String firstName, String last_name, String tel, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.last_name = last_name;
        this.tel = tel;
        this.email = email;
        this.password = password;
    }
}
