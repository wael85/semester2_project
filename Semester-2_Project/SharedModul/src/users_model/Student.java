package users_model;

import java.io.Serializable;

public class Student extends User implements Serializable {
    public String firstName;
    public String lastName;
    public String phone;
    public String email;

    public Student(String userName, String password, String firstName, String lastName, String email, String phone) {
        super(userName, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;


    }


    @Override
    public String getUserType() {
        return UsersTypes.STUDENT.name();
    }

    @Override
    public String toString() {
        return
                super.toString()+
                        ", firstName: " + firstName +
                        ", last_name: " + lastName +
                        ", phone: " + phone+
                        ", email: " + email;
    }
}
