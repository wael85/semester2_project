import client.ManageUserClient;
import client.ManageUserClientInterface;
import model.users_mangment.UsersManagementModelManger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import users_model.User;


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
    public void adminAddStudentWithEmptyData() {

        assertThrows(IllegalArgumentException.class, () -> client.createStudent("", "", "", "", "", ""));

    }
    //username validator test.

    @Test
    public void adminAddingStudentWithEmptyUsername() {
        assertThrows(IllegalArgumentException.class, () -> client.createStudent("", "Student0000", "firstname", "lastname", "Student@gmail.com", "123456789"));
    }

    @Test
    public void adminAddingStudentWithUsernameLessThan3() {
        assertThrows(IllegalArgumentException.class, () -> client.createStudent("ST", "Student0000", "firstname", "lastname", "Student@gmail.com", "123456789"));
    }

    @Test
    public void adminAddingStudentWithUsername3() throws RemoteException {
        client.createStudent("Stu", "Student0000", "firstname", "lastname", "Student@gmail.com", "123456789");
        boolean isThere = false;
        for (User u : client.getAllUsers().getUsers()) {
            if (u.getUserName().equals("Stu")) {
                isThere = true;
            }
        }
        assertTrue(isThere);
    }
    @Test
    public void deleteStuden() throws RemoteException {
        client.deleteUser("Stu");
    }



    @Test
    public void adminAddingStudentWithUsernameMoreThan3() throws RemoteException {
        client.createStudent("Student", "Student0000", "firstname", "lastname", "Student@gmail.com", "123456789");
        boolean isThere = false;
        for (User u : client.getAllUsers().getUsers()) {
            if (u.getUserName().equals("Student")) {
                isThere = true;
            }
        }
        assertTrue(isThere);
    }
    @Test
    public void deleteStudent() throws RemoteException {
        client.deleteUser("Student");
    }
    //Password validation test.
    @Test
    public void adminAddingStudentWithEmptyPassword() {
        assertThrows(IllegalArgumentException.class, () -> client.createStudent("Student", "", "firstname", "lastname", "Student@gmail.com", "123456789"));
    }

    @Test
    public void adminAddingStudentWithPasswordDontContainUppercase() {
        assertThrows(IllegalArgumentException.class, () -> client.createStudent("Student", "password0000", "firstname", "lastname", "Student@gmail.com", "123456789"));
    }

    @Test
    public void adminAddingStudentWithPasswordDontContainLowercase() {
        assertThrows(IllegalArgumentException.class, () -> client.createStudent("Student", "PASSWORD0000", "firstname", "lastname", "Student@gmail.com", "123456789"));
    }

    @Test
    public void adminAddingStudentWithPasswordDontContainNumbers() {
        assertThrows(IllegalArgumentException.class, () -> client.createStudent("Student", "Password", "firstname", "lastname", "Student@gmail.com", "123456789"));
    }








    //Phone number validation test
    @Test
    public void adminAddingStudentWithEmptyPhone() {
        assertThrows(IllegalArgumentException.class, () -> client.createStudent("Student", "password0000", "firstname", "lastname", "Student@gmail.com", ""));
    }

    @Test
    public void adminAddingStudentWithLetterInTheFirstOfPhone() {
        assertThrows(IllegalArgumentException.class, () -> client.createStudent("Student", "password0000", "firstname", "lastname", "Student@gmail.com", "a12345678"));
    }

    @Test
    public void adminAddingStudentWithLetterInTheMiddleOfPhone() {
        assertThrows(IllegalArgumentException.class, () -> client.createStudent("Student", "password0000", "firstname", "lastname", "Student@gmail.com", "1234a5678"));
    }

    @Test
    public void adminAddingStudentWithLetterInTheEndOfPhone() {
        assertThrows(IllegalArgumentException.class, () -> client.createStudent("Student", "password0000", "firstname", "lastname", "Student@gmail.com", "123456789a"));
    }

    //Email validation test

    @Test
    public void adminAddingStudentWithEmptyEmail() {
        assertThrows(IllegalArgumentException.class, () -> client.createStudent("Student", "password0000", "firstname", "lastname", "", "123456789"));
    }

    @Test
    public void adminAddingStudentWithoutHostInEmail() {
        assertThrows(IllegalArgumentException.class, () -> client.createStudent("Student", "password0000", "firstname", "lastname", "Studentgmail.com", "123456789"));
    }

    @Test
    public void adminAddingStudentWithoutPortInEmail() {
        assertThrows(IllegalArgumentException.class, () -> client.createStudent("Student", "password0000", "firstname", "lastname", "Student@gmailcom", "123456789"));
    }

    //Administrator Create another Administrator

    @Test
    public void adminAddAdminWithEmptyData() {

        assertThrows(IllegalArgumentException.class, () -> client.createAdmin("", "", "", "", "", ""));

    }
    //username validator test.

    @Test
    public void adminAddingAdminWithEmptyUsername() {
        assertThrows(IllegalArgumentException.class, () -> client.createAdmin("", "Password0000", "firstname", "lastname", "Admin@gmail.com", "12345678"));
    }

    @Test
    public void adminAddingAdminWithUsernameLessThan6() {
        assertThrows(IllegalArgumentException.class, () -> client.createAdmin("Admin", "Password0000", "firstname", "lastname", "Admin@gmail.com", "12345678"));
    }

    @Test
    public void adminAddingAdminWithUsername6() throws RemoteException {
        client.createAdmin("Admin1", "Password0000", "firstname", "lastname", "Admin@gmail.com", "12345678");
        boolean isThere = false;
        for (User u : client.getAllUsers().getUsers()) {
            if (u.getUserName().equals("Admin1")) {
                isThere = true;
            }
        }
        assertTrue(isThere);
    }

    @Test
    public void deleteAdmin1() throws RemoteException {
        client.deleteUser("Admin1");
    }

    @Test
    public void adminAddingAdminWithUsernameMoreThan3() throws RemoteException {
        client.createAdmin("Admin12", "Password0000", "firstname", "lastname", "Admin@gmail.com", "12345678");
        boolean isThere = false;
        for (User u : client.getAllUsers().getUsers()) {
            if (u.getUserName().equals("Admin12")) {
                isThere = true;
            }
        }
        assertTrue(isThere);
    }

    @Test
    public void deleteAdmin12() throws RemoteException {
        client.deleteUser("Admin12");

    }


    //Password validation test.
    @Test
    public void adminAddingAdminWithEmptyPassword() {
        assertThrows(IllegalArgumentException.class, () -> client.createAdmin("Admin1", "", "firstname", "lastname", "Admin@gmail.com", "12345678"));
    }

    @Test
    public void adminAddingAdminWithPasswordDontContainUppercase() {
        assertThrows(IllegalArgumentException.class, () -> client.createAdmin("Admin1", "password0000", "firstname", "lastname", "Admin@gmail.com", "12345678"));
    }

    @Test
    public void adminAddingAdminWithPasswordDontContainLowercase() {
        assertThrows(IllegalArgumentException.class, () -> client.createAdmin("Admin1", "PASSWORD0000", "firstname", "lastname", "Admin@gmail.com", "12345678"));
    }

    @Test
    public void adminAddingAdminWithPasswordDontContainNumbers() {
        assertThrows(IllegalArgumentException.class, () -> client.createAdmin("Admin1", "Password", "firstname", "lastname", "Admin@gmail.com", "12345678"));
    }


    //Phone number validation test
    @Test
    public void adminAddingAdminWithEmptyPhone() {
        assertThrows(IllegalArgumentException.class, () -> client.createAdmin("Admin1", "Password0000", "firstname", "lastname", "Admin@gmail.com", ""));
    }

    @Test
    public void adminAddingAdminWithLetterInTheFirstOfPhone() {
        assertThrows(IllegalArgumentException.class, () -> client.createAdmin("Admin1", "Password0000", "firstname", "lastname", "Admin@gmail.com", "a12345678"));
    }

    @Test
    public void adminAddingAdminWithLetterInTheMiddleOfPhone() {
        assertThrows(IllegalArgumentException.class, () -> client.createAdmin("Admin1", "Password0000", "firstname", "lastname", "Admin@gmail.com", "1234a5678"));
    }

    @Test
    public void adminAddingAdminWithLetterInTheEndOfPhone() {
        assertThrows(IllegalArgumentException.class, () -> client.createAdmin("Admin1", "Password0000", "firstname", "lastname", "Admin@gmail.com", "12345678a"));
    }

    //Email validation test

    @Test
    public void adminAddingAdminWithEmptyEmail() {
        assertThrows(IllegalArgumentException.class, () -> client.createAdmin("Admin1", "Password0000", "firstname", "lastname", "", "12345678"));
    }

    @Test
    public void adminAddingAdminWithoutHostInEmail() {
        assertThrows(IllegalArgumentException.class, () -> client.createAdmin("Admin1", "Password0000", "firstname", "lastname", "Admingmail.com", "12345678"));
    }

    @Test
    public void adminAddingAdminWithoutPortInEmail() {
        assertThrows(IllegalArgumentException.class, () -> client.createAdmin("Admin1", "Password0000", "firstname", "lastname", "Admin@gmailcom", "12345678"));
    }

    //Administrator create Teacher Test:

    @Test
    public void adminAddTeacherWithEmptyData() {

        assertThrows(IllegalArgumentException.class, () -> client.createTeacher("", "", "", "", "", ""));

    }
    //username validator test.

    @Test
    public void adminAddingTeacherWithEmptyUsername() {
        assertThrows(IllegalArgumentException.class, () -> client.createTeacher("", "Password0000", "firstname", "lastname", "Teacher@gmail.com", "123456789"));
    }

    @Test
    public void adminAddingTeacherWithUsernameLessThan6() {
        assertThrows(IllegalArgumentException.class, () -> client.createTeacher("TEA", "Password0000", "firstname", "lastname", "Teacher@gmail.com", "123456789"));
    }

    @Test
    public void adminAddingTeacherWithUsername6() throws RemoteException {
        client.createTeacher("Teache", "Password0000", "firstname", "lastname", "Teacher@gmail.com", "123456789");
        boolean isThere = false;
        for (User u : client.getAllUsers().getUsers()) {
            if (u.getUserName().equals("Teache")) {
                isThere = true;
            }
        }
        assertTrue(isThere);
    }

    @Test
    public void deleteTeache() throws RemoteException {
        client.deleteUser("Teache");
    }

    @Test
    public void adminAddingTeacherWithUsernameMoreThan6() throws RemoteException {
        client.createTeacher("TEACHER", "Password0000", "firstname", "lastname", "Teacher@gmail.com", "123456789");
        boolean isThere = false;
        for (User u : client.getAllUsers().getUsers()) {
            if (u.getUserName().equals("TEACHER")) {
                isThere = true;
            }
        }
        assertTrue(isThere);
    }

    @Test
    public void deleteTEACHER() throws RemoteException {
        client.deleteUser("TEACHER");
    }


    //Password validation test.
    @Test
    public void adminAddingTeacherWithEmptyPassword() {
        assertThrows(IllegalArgumentException.class, () -> client.createTeacher("Teacher", "", "firstname", "lastname", "Teacher@gmail.com", "123456789"));
    }

    @Test
    public void adminAddingTeacherWithPasswordDontContainUppercase() {
        assertThrows(IllegalArgumentException.class, () -> client.createTeacher("Teacher", "password0000", "firstname", "lastname", "Teacher@gmail.com", "123456789"));
    }

    @Test
    public void adminAddingTeacherWithPasswordDontContainLowercase() {
        assertThrows(IllegalArgumentException.class, () -> client.createTeacher("Teacher", "PASSWORD0000", "firstname", "lastname", "Teacher@gmail.com", "123456789"));
    }

    @Test
    public void adminAddingTeacherWithPasswordDontContainNumbers() {
        assertThrows(IllegalArgumentException.class, () -> client.createTeacher("Teacher", "Password", "firstname", "lastname", "Teacher@gmail.com", "123456789"));
    }


    //Phone number validation test
    @Test
    public void adminAddingTeacherWithEmptyPhone() {
        assertThrows(IllegalArgumentException.class, () -> client.createTeacher("Teacher", "Password0000", "firstname", "lastname", "Teacher@gmail.com", ""));
    }

    @Test
    public void adminAddingTeacherWithLetterInTheFirstOfPhone() {
        assertThrows(IllegalArgumentException.class, () -> client.createTeacher("Teacher", "Password0000", "firstname", "lastname", "Teacher@gmail.com", "a123456789"));
    }

    @Test
    public void adminAddingTeacherWithLetterInTheMiddleOfPhone() {
        assertThrows(IllegalArgumentException.class, () -> client.createTeacher("Teacher", "Password0000", "firstname", "lastname", "Teacher@gmail.com", "1234a5678"));
    }

    @Test
    public void adminAddingTeacherWithLetterInTheEndOfPhone() {
        assertThrows(IllegalArgumentException.class, () -> client.createTeacher("Teacher", "Password0000", "firstname", "lastname", "Teacher@gmail.com", "12345678a"));
    }

    //Email validation test

    @Test
    public void adminAddingTeacherWithEmptyEmail() {
        assertThrows(IllegalArgumentException.class, () -> client.createTeacher("Teacher", "Password0000", "firstname", "lastname", "", "12345678"));
    }

    @Test
    public void adminAddingTeacherWithoutHostInEmail() {
        assertThrows(IllegalArgumentException.class, () -> client.createTeacher("Teacher", "Password0000", "firstname", "lastname", "Teachergmail.com", "12345678"));
    }

    @Test
    public void adminAddingTeacherWithoutPortInEmail() {
        assertThrows(IllegalArgumentException.class, () -> client.createTeacher("Teacher", "Password0000", "firstname", "lastname", "Teacher@gmailcom", "12345678"));
    }

    //Administrator create Guest Test:


    @Test
    public void adminAddGuestWithEmptyData() {

        assertThrows(IllegalArgumentException.class, () -> client.createGuest("", "", "", "", ""));

    }
    //username validator test.

    @Test
    public void adminAddingGuestWithEmptyUsername() {
        assertThrows(IllegalArgumentException.class, () -> client.createGuest("", "Password0000", "company", "company@gmail.com", "12345678"));
    }

    @Test
    public void adminAddingGuestWithUsernameLessThan6() {
        assertThrows(IllegalArgumentException.class, () -> client.createGuest("CVR", "Password0000", "company", "company@gmail.com", "12345678"));
    }

    @Test
    public void adminAddingGuestWithUsername6() throws RemoteException {
        client.createGuest("CVRCVR", "Password0000", "company", "company@gmail.com", "12345678");
        boolean isThere = false;
        for (User u : client.getAllUsers().getUsers()) {
            if (u.getUserName().equals("CVRCVR")) {
                isThere = true;
            }
        }
        assertTrue(isThere);
    }

    @Test
    public void deleteCVRCVR() throws RemoteException {
        client.deleteUser("CVRCVR");
    }

    @Test
    public void adminAddingGuestWithUsernameMoreThan6() throws RemoteException {
        client.createGuest("CVRCVR1", "Password0000", "company", "company@gmail.com", "12345678");
        boolean isThere = false;
        for (User u : client.getAllUsers().getUsers()) {
            if (u.getUserName().equals("CVRCVR1")) {
                isThere = true;
            }
        }
        assertTrue(isThere);
    }

    @Test
    public void deleteCVRCVR1() throws RemoteException {
        client.deleteUser("CVRCVR1");
    }


    //Password validation test.
    @Test
    public void adminAddingGuestWithEmptyPassword() {
        assertThrows(IllegalArgumentException.class, () -> client.createGuest("CVRCVR", "", "company", "company@gmail.com", "12345678"));
    }

    @Test
    public void adminAddingGuestWithPasswordDontContainUppercase() {
        assertThrows(IllegalArgumentException.class, () -> client.createGuest("CVRCVR", "password0000", "company", "company@gmail.com", "12345678"));
    }

    @Test
    public void adminAddingGuestWithPasswordDontContainLowercase() {
        assertThrows(IllegalArgumentException.class, () -> client.createGuest("CVRCVR", "PASSWORD0000", "company", "company@gmail.com", "12345678"));
    }

    @Test
    public void adminAddingGuestWithPasswordDontContainNumbers() {
        assertThrows(IllegalArgumentException.class, () -> client.createGuest("CVRCVR", "Password", "company", "company@gmail.com", "12345678"));
    }


    //Phone number validation test
    @Test
    public void adminAddingGuestWithEmptyPhone() {
        assertThrows(IllegalArgumentException.class, () -> client.createGuest("CVRCVR", "Password0000", "company", "company@gmail.com", ""));
    }

    @Test
    public void adminAddingGuestWithLetterInTheFirstOfPhone() {
        assertThrows(IllegalArgumentException.class, () -> client.createGuest("CVRCVR", "Password0000", "company", "company@gmail.com", "a12345678"));
    }

    @Test
    public void adminAddingGuestWithLetterInTheMiddleOfPhone() {
        assertThrows(IllegalArgumentException.class, () -> client.createGuest("CVRCVR", "Password0000", "company", "company@gmail.com", "1234a5678"));
    }

    @Test
    public void adminAddingGuestWithLetterInTheEndOfPhone() {
        assertThrows(IllegalArgumentException.class, () -> client.createGuest("CVRCVR", "Password0000", "company", "company@gmail.com", "12345678a"));
    }

    //Email validation test

    @Test
    public void adminAddingGuestWithEmptyEmail() {
        assertThrows(IllegalArgumentException.class, () -> client.createGuest("CVRCVR", "Password0000", "company", "", "12345678"));
    }

    @Test
    public void adminAddingGuestWithoutHostInEmail() {
        assertThrows(IllegalArgumentException.class, () -> client.createGuest("CVRCVR", "Password0000", "company", "companygmail.com", "12345678"));
    }

    @Test
    public void adminAddingGuestWithoutPortInEmail() {
        assertThrows(IllegalArgumentException.class, () -> client.createGuest("CVRCVR", "Password0000", "company", "company@gmailcom", "12345678"));
    }


}
