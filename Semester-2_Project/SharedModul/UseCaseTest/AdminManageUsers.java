import client.ManageUserClient;
import client.ManageUserClientInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import users_model.*;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static org.junit.jupiter.api.Assertions.*;

public class AdminManageUsers {
    private UsersManagementModel client;



    @BeforeEach
    public void setup() throws RemoteException, NotBoundException, AlreadyBoundException {


        Registry registry = LocateRegistry.getRegistry("localhost", Registry.REGISTRY_PORT);
        ManageUserClientInterface manageUserClient = new ManageUserClient(registry);
        this.client = new UsersManagementModelManger(manageUserClient);


    }

    @AfterEach
    public void closeClient() throws IOException {
        client.close();

    }
    //Administrator can create a user of type administrator.
    @Test
    public void adminCanCreateAdmin() throws RemoteException {
        User user = new Administrator("Jon123", "Jon123456", "Jun", "Jon", "12345678", "Jon@gmail.com");
        client.createAdmin("Jon123", "Jon123456", "Jun", "Jon", "12345678", "Jon@gmail.com");
        boolean isThere = false;
        for (User x : client.getAllUsers().getUsers()) {
            if (x.getUserName().equals(user.getUserName())) {
                isThere = true;
            }
        }
        assertTrue(isThere);

    }

    @Test
    public void administratorCanDeleteAdministratorAfterAdding() throws RemoteException {
        User user = new Administrator("Jony123", "Jon123456", "Jun", "Jon", "12345678", "Jon@gmail.com");
        client.createAdmin("Jony123", "Jon123456", "Jun", "Jon", "12345678", "Jon@gmail.com");
        client.deleteUser("Jony123");
        boolean notThere = false;
        for (User x : client.getAllUsers().getUsers()) {
            if (x.getUserName().equals(user.getUserName())) {
                notThere = true;

            }
            assertFalse(notThere);

        }

    }
    @Test
    public void adminCannotCreateAdminWithEmptyData() throws RemoteException {
        assertThrows(RemoteException.class,()-> client.createAdmin("", "", "", "", "", ""));
    }
    //Administrator can create and remove a user of type Student.
    @Test
    public void administratorCreateAStudent() throws RemoteException {
        client.createStudent("Student","St123456","student","student","123456789","student@gmail.com");
        boolean isThere =false;
        for (User s:client.getAllUsers().getUsers()) {
            if (s.getUserName().equals("Student")){
                isThere=true;
            }
        }
        assertTrue(isThere);
    }

    @Test
    public void administratorCanDeleteStudentAfterAdding() throws RemoteException {
        User user = new Student("Jan123", "Jon123456", "Jun", "Jon", "12345678", "Jon@gmail.com");
        client.createStudent("Jan123", "Jon123456", "Jun", "Jon", "12345678", "Jon@gmail.com");
        client.deleteUser("Jan123");
        boolean notThere = false;
        for (User x : client.getAllUsers().getUsers()) {
            if (x.getUserName().equals(user.getUserName())) {
                notThere = true;

            }
            assertFalse(notThere);

        }

    }

    //Administrator can create and delete a user of type Teacher.

    @Test
    public void administratorCreateATeacher() throws RemoteException {
        client.createTeacher("Teacher","Te123456","teacher","tech","123456789","teacher@gmail.com");
        boolean isThere =false;
        for (User s:client.getAllUsers().getUsers()) {
            if (s.getUserName().equals("Teacher")){
                isThere=true;
            }
        }
        assertTrue(isThere);
    }

    @Test
    public void administratorCanDeleteTeacherAfterAdding() throws RemoteException {
        User user = new Teacher("Jon1234", "Jon123456", "Jun", "Jon", "12345678", "Jon@gmail.com");
        client.createTeacher("Jon1234", "Jon123456", "Jun", "Jon", "12345678", "Jon@gmail.com");
        client.deleteUser("Jon1234");
        boolean notThere = false;
        for (User x : client.getAllUsers().getUsers()) {
            if (x.getUserName().equals(user.getUserName())) {
                notThere = true;

            }
            assertFalse(notThere);

        }

    }

    //Administrator can create and delete a user of type Guest.
    @Test
    public void administratorCreateAGuest() throws RemoteException {
        client.createGuest("123456","Com123456","Company","12345678","Company@gmail.com");
        boolean isThere =false;
        for (User s:client.getAllUsers().getUsers()) {
            if (s.getUserName().equals("123456")){
                isThere=true;
            }
        }
        assertTrue(isThere);
    }

    @Test
    public void administratorCanDeleteGuestAfterAdding() throws RemoteException {
        User user = new Guest("1234567","Com123456","Company","12345678","Company@gmail.com");
        client.createGuest("1234567","Com123456","Company","12345678","Company@gmail.com");
        client.deleteUser("1234567");
        boolean notThere = false;
        for (User x : client.getAllUsers().getUsers()) {
            if (x.getUserName().equals(user.getUserName())) {
                notThere = true;

            }
            assertFalse(notThere);

        }

    }


}
