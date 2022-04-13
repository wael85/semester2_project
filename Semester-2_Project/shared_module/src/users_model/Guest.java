package users_model;

public class Guest {
    private int CVR;
    private String company_name;
    private int phone;
    private String email;
    private String password;

    public Guest(int CVR, String company_name, int phone, String email, String password) {

        this.CVR = CVR;
        this.company_name = company_name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }



    @Override
    public String toString() {
        return
                "CVR:" + CVR +
                ", company_name:'" + company_name +
                ", phone:" + phone +
                ", email:'" + email +
                ", password:" + password;
    }
}
