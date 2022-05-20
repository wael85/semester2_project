import client.ManageRoomClient;
import client.ManageRoomClientInterface;
import model.rooms.RoomManagementModelManage;
import org.junit.jupiter.api.*;


import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static org.junit.jupiter.api.Assertions.*;

public class TestAddingRoomsValidator {
    private RoomManagementModelManage client;

    @BeforeEach
    public void setup() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", Registry.REGISTRY_PORT);
        ManageRoomClientInterface manageRoomClient = new ManageRoomClient(registry);
        this.client = new RoomManagementModelManage(manageRoomClient);



    }

    @AfterEach
    public void close() throws IOException {
        client.close();
    }

    @Test
    public void AdminAddRoomWithEmptyData(){
        assertThrows(IllegalArgumentException.class,()-> client.createRoom("","","","",""));

    }
    //Building validator Test:

    @Test
    public void AdminAddRoomWithBuildingIsEmpty(){
        assertThrows(IllegalArgumentException.class,()-> client.createRoom("","1","1","CLASS_ROOM","1"));

    }
    @Test
    public void AdminAddRoomWithBuildingIsNumber(){
        assertThrows(IllegalArgumentException.class,()-> client.createRoom("1","1","1","CLASS_ROOM","1"));

    }
    @Test
    public void AdminAddRoomWithBuildingIsMoreOneUpperCace(){
        assertThrows(IllegalArgumentException.class,()-> client.createRoom("SS","1","1","CLASS_ROOM","1"));

    }
    @Test
    public void AdminAddRoomWithBuildingOneLowerOneUpper(){
        assertThrows(IllegalArgumentException.class,()-> client.createRoom("Ss","1","1","CLASS_ROOM","1"));

    }

    //Floor validator Test:
    @Test
    public void AdminAddRoomWithFloorIsEmpty(){
        assertThrows(IllegalArgumentException.class,()-> client.createRoom("S","","1","CLASS_ROOM","1"));

    }
    @Test
    public void AdminAddRoomWithFloorIsLetter(){
        assertThrows(IllegalArgumentException.class,()-> client.createRoom("1","a","1","CLASS_ROOM","1"));

    }
    @Test
    public void AdminAddRoomWithFloorMoreThan2Digits(){
        assertThrows(IllegalArgumentException.class,()-> client.createRoom("SS","123","1","CLASS_ROOM","1"));

    }
    @Test
    public void AdminAddRoomWithFloorNegativeNumber(){
        assertThrows(IllegalArgumentException.class,()-> client.createRoom("Ss","-1","1","CLASS_ROOM","1"));

    }

    //Room number validator Test:
    @Test
    public void AdminAddRoomWithNumberIsEmpty(){
        assertThrows(IllegalArgumentException.class,()-> client.createRoom("S","1","","CLASS_ROOM","1"));

    }
    @Test
    public void AdminAddRoomWithNumberIsLetter(){
        assertThrows(IllegalArgumentException.class,()-> client.createRoom("1","1","a","CLASS_ROOM","1"));

    }
    @Test
    public void AdminAddRoomWithNumberMoreThan3Digits(){
        assertThrows(IllegalArgumentException.class,()-> client.createRoom("SS","1","1234","CLASS_ROOM","1"));

    }
    @Test
    public void AdminAddRoomWithNumberNegativeNumber(){
        assertThrows(IllegalArgumentException.class,()-> client.createRoom("Ss","1","-1","CLASS_ROOM","1"));

    }


    //Room capacity validator test:
    @Test
    public void AdminAddStudyRoomWithCapacityMoreThen1Digit(){
        assertThrows(IllegalArgumentException.class,()-> client.createRoom("S","1","1","study room","11"));
    }

}
