package users_model;

public class Teacher {
    private int staff_number;
    private String f_name;
    private String l_name;
    private int phone;
    private String email;
    private String password;

    public Teacher(int staff_number, String f_name, String l_name, int phone, String email,String password) {
        this.staff_number = staff_number;
        this.f_name = f_name;
        this.l_name = l_name;
        this.phone = phone;
        this.email = email;
        this.password=password;
    }



    @Override
    public String toString() {
        return
                "Staff_number" + staff_number  +
                        ", first name: '" + f_name +
                        ", last name: '" + l_name  +
                        ", phone: " + phone +
                        ", email: '" + email ;
    }

}
