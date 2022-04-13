package users_model;

public class Student {
    public int student_id;
    public String firstName;
    public String last_name;
    public int phone;
    public String email;
    public String password;

    public Student(int student_id, String firstName, String last_name, int phone, String email, String password) {
        this.student_id = student_id;
        this.firstName = firstName;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }



    @Override
    public String toString() {
        return
                "Id=" + student_id +
                ", firstName:'" + firstName +
                ", last_name:'" + last_name +
                ", phone:" + phone +
                ", email:'" + email;
    }
}
