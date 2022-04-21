package users_model;

import java.io.Serializable;

public class Guest extends User implements Serializable {

    private String companyName;
    private String phone;
    private String email;


    public Guest(String userName, String password, String companyName, String phone, String email) {

        super(userName, password);
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;

    }



    @Override
    public String toString() {
        return
                super.toString()+
                        ", company_name: " + companyName +
                        ", phone: " + phone +
                        ", email: " + email;
    }
}
