import booking.Booking;
import client.*;
import model.booking.BookingModelManger;
import model.rooms.RoomManagementModelManage;
import model.users_mangment.UsersManagementModelManger;
import org.junit.jupiter.api.*;
import room_model.Room;
import user_state.UserState;
import users_model.Student;
import users_model.User;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.sql.Driver;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;



public class TestCasesTest {
    private UsersManagementModelManger client;
    private RoomManagementModelManage roomClient;
    private BookingModelManger bookingClient;
    private UserState current;

    @BeforeEach
    public void setup() throws NotBoundException, RemoteException {
        Registry registry = LocateRegistry.getRegistry("localhost", Registry.REGISTRY_PORT);
        ManageUserClientInterface manageUserClient = new ManageUserClient(registry);
        this.client = new UsersManagementModelManger(manageUserClient);

        ManageRoomClientInterface manageRoomClient = new ManageRoomClient(registry);
        this.roomClient = new RoomManagementModelManage(manageRoomClient);

        ClientBookingInterface clientBooking = new ClientBooking(registry);
        this.current=new UserState();
        this.bookingClient=new BookingModelManger(clientBooking,current);



    }
    @AfterEach
    public void close() throws IOException {
        client.close();
        roomClient.close();
    }


    @Test
    public void addANewAdminToTheSystem() throws RemoteException {
        client.createAdmin("Admin2","Admin0000","first","last","admin@gmail.com","12345678");
        boolean isThere=false;
        for (User user:client.getAllUsers().getUsers()) {
            if (user.getUserName().equals("Admin2")){
                isThere=true;
            }

        }
        assertTrue(isThere);
    }
    @Test
    public void addANewTeacherToTheSystem() throws RemoteException {
        client.createTeacher("Teacher2","Teacher0000","first","last","Teacher@gmail.com","12345678");
        boolean isThere=false;
        for (User user:client.getAllUsers().getUsers()) {
            if (user.getUserName().equals("Teacher2")){
                isThere=true;
            }

        }
        assertTrue(isThere);
    }
    @Test
    public void addANewStudentToTheSystem() throws RemoteException {
        client.createStudent("student","Student0000","first","last","Student@gmail.com","12345678");
        boolean isThere=false;
        for (User user:client.getAllUsers().getUsers()) {
            if (user.getUserName().equals("student")){
                isThere=true;
            }

        }
        assertTrue(isThere);
    }
    @Test
    public void addANewGuestToTheSystem() throws RemoteException {
        client.createGuest("Guest","Guest0000","first","Guest@gmail.com","123456789");
        boolean isThere=false;
        for (User user:client.getAllUsers().getUsers()) {
            if (user.getUserName().equals("Guest")){
                isThere=true;
            }

        }
        assertTrue(isThere);
    }
    @Test
    public void addANewAdminWithIValidInformationToTheSystem() throws RemoteException {

     assertThrows(IllegalArgumentException.class,()->client.createAdmin("user","password","first","last","Email","Phone"));
    }

    @Test
    public void addANewTeacherWithIValidInformationToTheSystem(){

        assertThrows(IllegalArgumentException.class,()->client.createTeacher("user","password","first","last","Email","Phone"));
    }
    @Test
    public void addANewStudentWithIValidInformationToTheSystem(){

        assertThrows(IllegalArgumentException.class,()->client.createStudent("user","password","first","last","Email","Phone"));
    }
    @Test
    public void addANewGuestWithIValidInformationToTheSystem() {

        assertThrows(IllegalArgumentException.class,()->client.createGuest("user","password","company","email","phone"));
    }
    @Test
    public void removeAnExistAdminFromTheSystem() throws RemoteException {
        client.deleteUser("Admin2");
        boolean isThere=false;
        for (User u:client.getAllUsers().getUsers()
             ) {
            if (u.getUserName().equals("Admin2")){
                isThere=true;
            }


        }
        assertFalse(isThere);
    }

    @Test
    public void removeAnExistTeacherFromTheSystem() throws RemoteException {
        client.deleteUser("Teacher2");
        boolean isThere=false;
        for (User u:client.getAllUsers().getUsers()
        ) {
            if (u.getUserName().equals("Teacher2")){
                isThere=true;
            }


        }
        assertFalse(isThere);
    }

    @Test
    public void removeAnExistStudentFromTheSystem() throws RemoteException {
        client.deleteUser("student");
        boolean isThere=false;
        for (User u:client.getAllUsers().getUsers()
        ) {
            if (u.getUserName().equals("student")){
                isThere=true;
            }


        }
        assertFalse(isThere);
    }
    @Test
    public void removeAnExistGuestFromTheSystem() throws RemoteException {
        client.deleteUser("Guest");
        boolean isThere=false;
        for (User u:client.getAllUsers().getUsers()
        ) {
            if (u.getUserName().equals("Guest")){
                isThere=true;
            }


        }
        assertFalse(isThere);
    }


    @Test
    public void addNewClassroomToTheSystem() throws RemoteException {
        roomClient.createRoom("S","1","12","class room","25");
        boolean isThere=false;
        for (Room r:roomClient.getAllRooms().getRooms()
             ) { if (r.getRoomId().equals("S1-12")){
                 isThere=true;
        }

        }
        assertTrue(isThere);
    }
    @Test
    public void addNewStudyRoomToTheSystem() throws RemoteException {
        roomClient.createRoom("S","2","12","study room","6");
        boolean isThere=false;
        for (Room r:roomClient.getAllRooms().getRooms()
        ) { if (r.getRoomId().equals("S2-12")){
            isThere=true;
        }

        }
        assertTrue(isThere);
    }
    @Test
    public void addNewAuditoryToTheSystem() throws RemoteException {
        roomClient.createRoom("S","3","12","auditory","6");
        boolean isThere=false;
        for (Room r:roomClient.getAllRooms().getRooms()
        ) { if (r.getRoomId().equals("S3-12")){
            isThere=true;
        }

        }
        assertTrue(isThere);
    }

    @Test
    public void removeAnExistClassroomFromTheSystem() throws RemoteException {
       roomClient.deleteRoom("S1-12");
        boolean isThere=false;
        for (Room r:roomClient.getAllRooms().getRooms()
        ) { if (r.getRoomId().equals("S1-12")){
            isThere=true;
        }

        }
        assertFalse(isThere);
    }
    @Test
    public void removeAnExistStudyRoomFromTheSystem() throws RemoteException {
        roomClient.deleteRoom("S2-12");
        boolean isThere=false;
        for (Room r:roomClient.getAllRooms().getRooms()
        ) { if (r.getRoomId().equals("S2-12")){
            isThere=true;
        }

        }
        assertFalse(isThere);
    }
    @Test
    public void removeAnExistAuditoryFromTheSystem() throws RemoteException {
        roomClient.deleteRoom("S3-12");
        boolean isThere=false;
        for (Room r:roomClient.getAllRooms().getRooms()
        ) { if (r.getRoomId().equals("S3-12")){
            isThere=true;
        }

        }
        assertFalse(isThere);
    }

@Test
    public void aUserCanBookARoom() throws RemoteException {
    User user =client.getAllUsers().getStudents().get(0);
    current.setCurrentUser(user);
    Timestamp start=new Timestamp(1);
    Timestamp end=new Timestamp(3);
    bookingClient.createBooking(bookingClient.getAvailableRooms(start,end).getRooms().get(0).getRoomId(),start,end);
        boolean isThere=false;
    for (Booking b:bookingClient.getUserBooking().getBookingList()) {
       if (b.toString().equals(bookingClient.getUserBooking().getBookingList().get(0).toString())){
           isThere=true;
       }

    }
    assertTrue(isThere);

}

@Test
public void userBookroomWithStartTimeNow() throws RemoteException {
    User user =client.getAllUsers().getStudents().get(0);
    current.setCurrentUser(user);
    Timestamp start=new Timestamp(LocalDateTime.now().getHour());
    Timestamp end=new Timestamp(16);
    assertThrows(RemoteException.class,()->bookingClient.createBooking(bookingClient.getAvailableRooms(start,end).getRooms().get(0).getRoomId(),start,end));
}
    @Test
    public void userBookRoomWithEndTimeSoFar() throws RemoteException {
        User user =client.getAllUsers().getStudents().get(0);
        current.setCurrentUser(user);
        Timestamp start=new Timestamp(15);
        Timestamp end=new Timestamp(23);
        assertThrows(RemoteException.class,()->bookingClient.createBooking(bookingClient.getAvailableRooms(start,end).getRooms().get(0).getRoomId(),start,end));
    }
@Test
    public void aUserCanCheckInToHisBookedRoom() throws RemoteException {

    User user =client.getAllUsers().getStudents().get(1);
    current.setCurrentUser(user);
    Timestamp start=new Timestamp(6);
    Timestamp end=new Timestamp(8);
    bookingClient.createBooking(bookingClient.getAvailableRooms(start,end).getRooms().get(0).getRoomId(),start,end);
      Booking booking= bookingClient.getUserBooking().getBookingList().get(0);
      bookingClient.checkIn(booking);
       assertTrue(bookingClient.getUserBooking().getBookingList().get(0).getIsCheckedIn());
}
@Test
    public void userCanCancelHisBooking() throws RemoteException {
    User user =client.getAllUsers().getStudents().get(1);
    current.setCurrentUser(user);
    Timestamp start=new Timestamp(6);
    Timestamp end=new Timestamp(8);
    bookingClient.createBooking(bookingClient.getAvailableRooms(start,end).getRooms().get(0).getRoomId(),start,end);
    Booking booking= bookingClient.getUserBooking().getBookingList().get(0);
    bookingClient.cancelBooking(booking);
    boolean notThere=false;
    for (Booking b:bookingClient.getUserBooking().getBookingList()) {
        if (b.toString().equals(bookingClient.getUserBooking().getBookingList().get(0).toString())){
            notThere=true;
        }

    }
    assertFalse(notThere);

}


}
