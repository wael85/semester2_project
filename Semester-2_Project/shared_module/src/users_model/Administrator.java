package users_model;

import java.io.Serializable;

public class Administrator implements Serializable {
    private String staffNumber;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;

    public Administrator(String  staffNumber, String firstName, String lastName, String phone, String email,String password) {

        this.staffNumber = staffNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password=password;
    }


    @Override
    public String toString() {
        return
                "Staff_number" + staffNumber  +
                ", first name: '" + firstName +
                ", last name: '" + lastName  +
                ", phone: " + phone +
                ", email: '" + email ;
    }
}
