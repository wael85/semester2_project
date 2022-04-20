package client;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.Registry;
import java.sql.SQLException;

public class ManageUserTest {
    public static void main(String[] args) throws NotBoundException, IOException, SQLException {
        ManageUserClientInterface client = new ManageUserClient("localhost", Registry.REGISTRY_PORT);
        System.out.println(client.createAdmin("dsf","sddfs","sdfs","dssf","sdfs","dew"));
        client.close();
    }
}