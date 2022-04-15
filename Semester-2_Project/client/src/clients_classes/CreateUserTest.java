package clients_classes;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.sql.SQLException;

public class CreateUserTest {
    public static void main(String[] args) throws NotBoundException, IOException, SQLException {
        CreateUserClientInterface client = new CreateUserClient("localhost", Registry.REGISTRY_PORT);
        System.out.println(client.createAdmin("dsfsf","sddfs","sdfs","dssf","sdfs","dew"));
        client.close();
    }
}
