package users_model;

import java.io.Serializable;

public class Guest implements Serializable {
    private String CVR;
    private String companyName;
    private String phone;
    private String email;
    private String password;

    public Guest(String CVR, String companyName, String phone, String email, String password) {

        this.CVR = CVR;
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }



    @Override
    public String toString() {
        return
                "CVR:" + CVR +
                ", company_name:'" + companyName +
                ", phone:" + phone +
                ", email:'" + email +
                ", password:" + password;
    }
}
