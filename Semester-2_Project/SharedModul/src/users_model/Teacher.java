package users_model;

import java.io.Serializable;

public class Teacher extends User implements Serializable {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;


    public Teacher(String userName, String password, String firstName, String lastName, String email, String phone) {
        super(userName, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;


    }


    @Override
    public String getUserType() {
        return UsersTypes.TEACHER.name();
    }

    @Override
    public String toString() {
        return
                super.toString() +
                        ", first name: " + firstName +
                        ", last name: " + lastName +
                        ", phone: " + phone +
                        ", email: " + email;
    }
}
