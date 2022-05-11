import client.ManageRoomClient;
import client.ManageRoomClientInterface;
import client.ManageUserClient;
import client.ManageUserClientInterface;
import javafx.application.Application;
import javafx.stage.Stage;
import room_model.RoomManagementModel;
import room_model.RoomManagementModelManage;
import users_model.UsersManagementModel;
import users_model.UsersManagementModelManger;
import view.ViewHandler;
import viewModel.ViewModelFactory;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", Registry.REGISTRY_PORT);
        ManageUserClientInterface manageUserClient = new ManageUserClient(registry);
       ManageRoomClientInterface manageRoomClient =new ManageRoomClient(registry);

        UsersManagementModel usersManagementModel = new UsersManagementModelManger(manageUserClient);
        RoomManagementModel roomManagementModel= new RoomManagementModelManage(manageRoomClient);
        ViewModelFactory viewModelFactory = new ViewModelFactory(usersManagementModel,roomManagementModel);
        ViewHandler viewHandler = new ViewHandler(primaryStage,viewModelFactory,usersManagementModel,roomManagementModel);
        viewHandler.start();
        primaryStage.getOnCloseRequest();
    }


}
