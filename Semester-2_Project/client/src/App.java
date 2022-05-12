import client.*;
import javafx.application.Application;
import javafx.stage.Stage;
import login.LoginModel;
import login.LoginModelManger;
import room_model.RoomManagementModel;
import room_model.RoomManagementModelManage;
import user_state.UserState;
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
        UserState currentUser = new UserState();
        ManageUserClientInterface manageUserClient = new ManageUserClient(registry);
       ManageRoomClientInterface manageRoomClient =new ManageRoomClient(registry);
        ClientLogin clientLogin = new ClientLogin(registry);
        LoginModel loginModel = new LoginModelManger(clientLogin);
        UsersManagementModel usersManagementModel = new UsersManagementModelManger(manageUserClient);
        RoomManagementModel roomManagementModel= new RoomManagementModelManage(manageRoomClient);
        ViewModelFactory viewModelFactory = new ViewModelFactory(usersManagementModel,roomManagementModel,loginModel);
        ViewHandler viewHandler = new ViewHandler(primaryStage,viewModelFactory,usersManagementModel,roomManagementModel, loginModel);
        viewHandler.start();
        primaryStage.getOnCloseRequest();
    }


}
