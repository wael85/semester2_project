package users_model;

import java.io.Serializable;

public class Student implements Serializable {
    public String studentId;
    public String firstName;
    public String lastName;
    public String phone;
    public String email;
    public String password;

    public Student(String studentId, String firstName, String lastName, String phone, String email, String password) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;

    }



    @Override
    public String toString() {
        return
                "Id=" + studentId +
                ", firstName:'" + firstName +
                ", last_name:'" + lastName +
                ", phone:" + phone +
                ", email:'" + email;
    }
}
