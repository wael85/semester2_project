import client.ManageUserClient;
import client.ManageUserClientInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import users_model.User;
import users_model.UsersManagementModelManger;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestAddingUsersValidator {

    private UsersManagementModelManger client;

    @BeforeEach
    public void setup() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", Registry.REGISTRY_PORT);
        ManageUserClientInterface manageUserClient = new ManageUserClient(registry);
        this.client = new UsersManagementModelManger(manageUserClient);



    }

    @AfterEach
    public void close() throws IOException {
        client.close();
    }


    //Administrator Create A student:

    @Test
    public void adminAddStudentWithEmptyData(){

        assertThrows(IllegalArgumentException.class,() -> client.createStudent("","","","","",""));

    }
    //username validator test.

    @Test
    public void adminAddingStudentWithEmptyUsername(){
    assertThrows(IllegalArgumentException.class,() -> client.createStudent("","student","lastname","12345678","Student@gmail.com","Student0000"));
    }
    @Test
    public void adminAddingStudentWithUsernameLessThan3(){
        assertThrows(IllegalArgumentException.class,() -> client.createStudent("ST","student","lastname","12345678","Student@gmail.com","Student0000"));
    }
    @Test
    public void adminAddingStudentWithUsername3() throws RemoteException {
        client.createStudent("STU","student","lastname","12345678","Student@gmail.com","Student0000");
        boolean isThere=false;
        for (User u:client.getAllUsers().getUsers()) {
            if (u.getUserName().equals("STU")){
                isThere=true;
            }
        }
        assertTrue(isThere);
    }
    @Test
    public void adminAddingStudentWithUsernameMoreThan3() throws RemoteException {
        client.createStudent("STUDENT","student","lastname","12345678","Student@gmail.com","Student0000");
        boolean isThere=false;
        for (User u:client.getAllUsers().getUsers()) {
            if (u.getUserName().equals("STU")){
                isThere=true;
            }
        }
        assertTrue(isThere);
    }


    //Password validation test.
    @Test
    public void adminAddingStudentWithEmptyPassword(){
        assertThrows(IllegalArgumentException.class,()-> client.createStudent("Student","firstname","lastname","13456789","Jak@gmail.com",""));
    }
    @Test
    public void adminAddingStudentWithPasswordDontContainUppercase(){
        assertThrows(IllegalArgumentException.class,()-> client.createStudent("Student","firstname","lastname","13456789","Jak@gmail.com","pass0000"));
    }

    @Test
    public void adminAddingStudentWithPasswordDontContainLowercase(){
        assertThrows(IllegalArgumentException.class,()-> client.createStudent("Student","firstname","lastname","13456789","Jak@gmail.com","PASS0000"));
    }
    @Test
    public void adminAddingStudentWithPasswordDontContainNumbers(){
        assertThrows(IllegalArgumentException.class,()-> client.createStudent("Student","firstname","lastname","13456789","Jak@gmail.com","PassWord"));
    }



    //Phone number validation test
    @Test
    public void adminAddingStudentWithEmptyPhone(){
        assertThrows(IllegalArgumentException.class,()-> client.createStudent("Student","firstname","lastname","","Jak@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingStudentWithLetterInTheFirstOfPhone(){
        assertThrows(IllegalArgumentException.class,()-> client.createStudent("Student","firstname","lastname","a12345678","Jak@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingStudentWithLetterInTheMiddleOfPhone(){
        assertThrows(IllegalArgumentException.class,()-> client.createStudent("Student","firstname","lastname","1234a5678","Jak@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingStudentWithLetterInTheEndOfPhone(){
        assertThrows(IllegalArgumentException.class,()-> client.createStudent("Student","firstname","lastname","12345678a","Jak@gmail.com","Pass0000"));
    }

    //Email validation test

    @Test
    public void adminAddingStudentWithEmptyEmail(){
        assertThrows(IllegalArgumentException.class,()-> client.createStudent("Student","firstname","lastname","12345678","","Pass0000"));
    }
    @Test
    public void adminAddingStudentWithoutHostInEmail(){
        assertThrows(IllegalArgumentException.class,()-> client.createStudent("Student","firstname","lastname","12345678","Jakgmail.com","Pass0000"));
    }
    @Test
    public void adminAddingStudentWithoutPortInEmail(){
        assertThrows(IllegalArgumentException.class,()-> client.createStudent("Student","firstname","lastname","12345678","Jak@gmail","Pass0000"));
    }

    //Administrator Create another Administrator

    @Test
    public void adminAddAdminWithEmptyData(){

        assertThrows(IllegalArgumentException.class,() -> client.createAdmin("","","","","",""));

    }
    //username validator test.

    @Test
    public void adminAddingAdminWithEmptyUsername(){
        assertThrows(IllegalArgumentException.class,() -> client.createAdmin("","firstname","lastname","12345678","Admin@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingAdminWithUsernameLessThan3(){
        assertThrows(IllegalArgumentException.class,() -> client.createAdmin("AD","firstname","lastname","12345678","Admin@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingAdminWithUsername3() throws RemoteException {
        client.createAdmin("ADM","firstname","lastname","12345678","Admin@gmail.com","Pass0000");
        boolean isThere=false;
        for (User u:client.getAllUsers().getUsers()) {
            if (u.getUserName().equals("ADM")){
                isThere=true;
            }
        }
        assertTrue(isThere);
    }
    @Test
    public void adminAddingAdminWithUsernameMoreThan3() throws RemoteException {
        client.createAdmin("ADMIN","firstname","lastname","12345678","Admin@gmail.com","Pass0000");
        boolean isThere=false;
        for (User u:client.getAllUsers().getUsers()) {
            if (u.getUserName().equals("ADMIN")){
                isThere=true;
            }
        }
        assertTrue(isThere);
    }


    //Password validation test.
    @Test
    public void adminAddingAdminWithEmptyPassword(){
        assertThrows(IllegalArgumentException.class,()-> client.createAdmin("Admin","firstname","lastname","13456789","Jak@gmail.com",""));
    }
    @Test
    public void adminAddingAdminWithPasswordDontContainUppercase(){
        assertThrows(IllegalArgumentException.class,()-> client.createAdmin("Admin","firstname","lastname","13456789","Jak@gmail.com","pass0000"));
    }

    @Test
    public void adminAddingAdminWithPasswordDontContainLowercase(){
        assertThrows(IllegalArgumentException.class,()-> client.createAdmin("Admin","firstname","lastname","13456789","Jak@gmail.com","PASS0000"));
    }
    @Test
    public void adminAddingAdminWithPasswordDontContainNumbers(){
        assertThrows(IllegalArgumentException.class,()-> client.createAdmin("Admin","firstname","lastname","13456789","Jak@gmail.com","PassWord"));
    }



    //Phone number validation test
    @Test
    public void adminAddingAdminWithEmptyPhone(){
        assertThrows(IllegalArgumentException.class,()-> client.createAdmin("Admin","firstname","lastname","","Jak@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingAdminWithLetterInTheFirstOfPhone(){
        assertThrows(IllegalArgumentException.class,()-> client.createAdmin("Admin","firstname","lastname","a12345678","Jak@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingAdminWithLetterInTheMiddleOfPhone(){
        assertThrows(IllegalArgumentException.class,()-> client.createAdmin("Admin","firstname","lastname","1234a5678","Jak@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingAdminWithLetterInTheEndOfPhone(){
        assertThrows(IllegalArgumentException.class,()-> client.createAdmin("Admin","firstname","lastname","12345678a","Jak@gmail.com","Pass0000"));
    }

    //Email validation test

    @Test
    public void adminAddingAdminWithEmptyEmail(){
        assertThrows(IllegalArgumentException.class,()-> client.createAdmin("Admin","firstname","lastname","12345678","","Pass0000"));
    }
    @Test
    public void adminAddingAdminWithoutHostInEmail(){
        assertThrows(IllegalArgumentException.class,()-> client.createAdmin("Admin","firstname","lastname","12345678","Jakgmail.com","Pass0000"));
    }
    @Test
    public void adminAddingAdminWithoutPortInEmail(){
        assertThrows(IllegalArgumentException.class,()-> client.createAdmin("Admin","firstname","lastname","12345678","Jak@gmail","Pass0000"));
    }

    //Administrator create Teacher Test:

    @Test
    public void adminAddTeacherWithEmptyData(){

        assertThrows(IllegalArgumentException.class,() -> client.createTeacher("","","","","",""));

    }
    //username validator test.

    @Test
    public void adminAddingTeacherWithEmptyUsername(){
        assertThrows(IllegalArgumentException.class,() -> client.createTeacher("","firstname","lastname","12345678","Teacher@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingTeacherWithUsernameLessThan3(){
        assertThrows(IllegalArgumentException.class,() -> client.createTeacher("TE","firstname","lastname","12345678","Teacher@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingTeacherWithUsername3() throws RemoteException {
        client.createTeacher("TEA","firstname","lastname","12345678","Teacher@gmail.com","Pass0000");
        boolean isThere=false;
        for (User u:client.getAllUsers().getUsers()) {
            if (u.getUserName().equals("TEA")){
                isThere=true;
            }
        }
        assertTrue(isThere);
    }
    @Test
    public void adminAddingTeacherWithUsernameMoreThan3() throws RemoteException {
        client.createTeacher("TEACHER","firstname","lastname","12345678","Teacher@gmail.com","Pass0000");
        boolean isThere=false;
        for (User u:client.getAllUsers().getUsers()) {
            if (u.getUserName().equals("TEACHER")){
                isThere=true;
            }
        }
        assertTrue(isThere);
    }


    //Password validation test.
    @Test
    public void adminAddingTeacherWithEmptyPassword(){
        assertThrows(IllegalArgumentException.class,()-> client.createTeacher("User","firstname","lastname","13456789","Jak@gmail.com",""));
    }
    @Test
    public void adminAddingTeacherWithPasswordDontContainUppercase(){
        assertThrows(IllegalArgumentException.class,()-> client.createTeacher("User","firstname","lastname","13456789","Jak@gmail.com","pass0000"));
    }

    @Test
    public void adminAddingTeacherWithPasswordDontContainLowercase(){
        assertThrows(IllegalArgumentException.class,()-> client.createTeacher("User","firstname","lastname","13456789","Jak@gmail.com","PASS0000"));
    }
    @Test
    public void adminAddingTeacherWithPasswordDontContainNumbers(){
        assertThrows(IllegalArgumentException.class,()-> client.createTeacher("User","firstname","lastname","13456789","Jak@gmail.com","PassWord"));
    }



    //Phone number validation test
    @Test
    public void adminAddingTeacherWithEmptyPhone(){
        assertThrows(IllegalArgumentException.class,()-> client.createTeacher("User","firstname","lastname","","Jak@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingTeacherWithLetterInTheFirstOfPhone(){
        assertThrows(IllegalArgumentException.class,()-> client.createTeacher("User","firstname","lastname","a12345678","Jak@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingTeacherWithLetterInTheMiddleOfPhone(){
        assertThrows(IllegalArgumentException.class,()-> client.createTeacher("User","firstname","lastname","1234a5678","Jak@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingTeacherWithLetterInTheEndOfPhone(){
        assertThrows(IllegalArgumentException.class,()-> client.createTeacher("User","firstname","lastname","12345678a","Jak@gmail.com","Pass0000"));
    }

    //Email validation test

    @Test
    public void adminAddingTeacherWithEmptyEmail(){
        assertThrows(IllegalArgumentException.class,()-> client.createTeacher("User","firstname","lastname","12345678","","Pass0000"));
    }
    @Test
    public void adminAddingTeacherWithoutHostInEmail(){
        assertThrows(IllegalArgumentException.class,()-> client.createTeacher("User","firstname","lastname","12345678","Jakgmail.com","Pass0000"));
    }
    @Test
    public void adminAddingTeacherWithoutPortInEmail(){
        assertThrows(IllegalArgumentException.class,()-> client.createTeacher("User","firstname","lastname","12345678","Jak@gmail","Pass0000"));
    }

    //Administrator create Guest Test:


    @Test
    public void adminAddGuestWithEmptyData(){

        assertThrows(IllegalArgumentException.class,() -> client.createGuest("","","","",""));

    }
    //username validator test.

    @Test
    public void adminAddingGuestWithEmptyUsername(){
        assertThrows(IllegalArgumentException.class,() -> client.createGuest("","companyName","12345678","Guest@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingGuestWithUsernameLessThan3(){
        assertThrows(IllegalArgumentException.class,() -> client.createGuest("CV","companyName","12345678","Guest@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingGuestWithUsername3() throws RemoteException {
        client.createGuest("CVR","companyName","12345678","Guest@gmail.com","Pass0000");
        boolean isThere=false;
        for (User u:client.getAllUsers().getUsers()) {
            if (u.getUserName().equals("CVR")){
                isThere=true;
            }
        }
        assertTrue(isThere);
    }
    @Test
    public void adminAddingGuestWithUsernameMoreThan3() throws RemoteException {
        client.createGuest("CVRE","companyName","12345678","Guest@gmail.com","Pass0000");
        boolean isThere=false;
        for (User u:client.getAllUsers().getUsers()) {
            if (u.getUserName().equals("CVRE")){
                isThere=true;
            }
        }
        assertTrue(isThere);
    }


    //Password validation test.
    @Test
    public void adminAddingGuestWithEmptyPassword(){
        assertThrows(IllegalArgumentException.class,()-> client.createGuest("User","companyName","13456789","Guest@gmail.com",""));
    }
    @Test
    public void adminAddingGuestWithPasswordDontContainUppercase(){
        assertThrows(IllegalArgumentException.class,()-> client.createGuest("User","companyName","13456789","Guest@gmail.com","pass0000"));
    }

    @Test
    public void adminAddingGuestWithPasswordDontContainLowercase(){
        assertThrows(IllegalArgumentException.class,()-> client.createGuest("User","companyName","13456789","Guest@gmail.com","PASS0000"));
    }
    @Test
    public void adminAddingGuestWithPasswordDontContainNumbers(){
        assertThrows(IllegalArgumentException.class,()-> client.createGuest("User","companyName","13456789","Guest@gmail.com","PassWord"));
    }



    //Phone number validation test
    @Test
    public void adminAddingGuestWithEmptyPhone(){
        assertThrows(IllegalArgumentException.class,()-> client.createGuest("User","companyName","","Guest@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingGuestWithLetterInTheFirstOfPhone(){
        assertThrows(IllegalArgumentException.class,()-> client.createGuest("User","companyName","a12345678","Guest@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingGuestWithLetterInTheMiddleOfPhone(){
        assertThrows(IllegalArgumentException.class,()-> client.createGuest("User","companyName","1234a5678","Guest@gmail.com","Pass0000"));
    }
    @Test
    public void adminAddingGuestWithLetterInTheEndOfPhone(){
        assertThrows(IllegalArgumentException.class,()-> client.createGuest("User","companyName","12345678a","Guest@gmail.com","Pass0000"));
    }

    //Email validation test

    @Test
    public void adminAddingGuestWithEmptyEmail(){
        assertThrows(IllegalArgumentException.class,()-> client.createGuest("User","companyName","12345678","","Pass0000"));
    }
    @Test
    public void adminAddingGuestWithoutHostInEmail(){
        assertThrows(IllegalArgumentException.class,()-> client.createGuest("User","companyName","12345678","Guestgmail.com","Pass0000"));
    }
    @Test
    public void adminAddingGuestWithoutPortInEmail(){
        assertThrows(IllegalArgumentException.class,()-> client.createGuest("User","companyName","12345678","Guest@gmail","Pass0000"));
    }












}
