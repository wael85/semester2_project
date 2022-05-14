import client.ManageRoomClient;
import client.ManageRoomClientInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import room_model.Room;
import room_model.RoomManagementModel;
import room_model.RoomManagementModelManage;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminManageRooms {
    private RoomManagementModel client;

    @BeforeEach
    public void setup() throws RemoteException, NotBoundException, AlreadyBoundException {


        Registry registry = LocateRegistry.getRegistry("localhost", Registry.REGISTRY_PORT);
        ManageRoomClientInterface manageRoomClient = new ManageRoomClient(registry);
        this.client = new RoomManagementModelManage(manageRoomClient);


    }

    @AfterEach
    public void closeClient() throws IOException {
        client.close();

    }

    //Administrator can create and delete a room.
    @Test
    public void administratorCanCreateARoom() throws RemoteException {
        client.createRoom("S","5","1","class room","10");
        boolean isThere=false;
        for (Room r:client.getAllRooms().getRooms()) {
            if (r.getRoomId().equals("S5-1")){
                isThere=true;
            }

        }
        assertTrue(isThere);
    }

    @Test
    public void adminCanDeleteRoomAfterAdding() throws RemoteException {
        client.createRoom("C","4","8","class room","6");
        client.deleteRoom("C4-8");
        boolean notThere=true;
        for (Room r:client.getAllRooms().getRooms()) {
            if (r.getRoomId().equals("C4-8")){
                notThere=false;
            }

        }
        assertTrue(notThere);
    }


}
