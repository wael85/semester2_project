package users_model;

import java.io.Serializable;

public class Administrator extends User implements Serializable {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;


    public Administrator(String  username,String password, String firstName, String lastName, String email, String phone) {
        super(username,password);

        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;

    }


    @Override
    public String getUserType() {
        return UsersTypes.ADMINISTRATOR.name();
    }

    @Override
    public String toString() {
        return   super.toString()+
                ", first name: " + firstName +
                ", last name: " + lastName  +
                ", phone: " + phone +
                ", email: " + email ;
    }

}
