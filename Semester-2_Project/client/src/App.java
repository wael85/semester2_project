import client.*;
import javafx.application.Application;
import javafx.stage.Stage;
import model.login.LoginModel;
import model.login.LoginModelManger;
import model.booking.BookingModel;
import model.booking.BookingModelManger;
import model.rooms.RoomManagementModel;
import model.rooms.RoomManagementModelManage;
import user_state.UserState;
import model.users_mangment.UsersManagementModel;
import model.users_mangment.UsersManagementModelManger;
import view.ViewHandler;
import viewModel.ViewModelFactory;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Registry registry = LocateRegistry.getRegistry("10.154.194.20", Registry.REGISTRY_PORT);
        System.out.println(registry);
        UserState currentUser = new UserState();
        ClientBookingInterface clientBooking = new ClientBooking(registry);
        ManageUserClientInterface manageUserClient = new ManageUserClient(registry);
       ManageRoomClientInterface manageRoomClient =new ManageRoomClient(registry);
        ClientLogin clientLogin = new ClientLogin(registry);
        LoginModel loginModel = new LoginModelManger(clientLogin,currentUser);
        BookingModel bookingModel = new BookingModelManger(clientBooking , currentUser);
        UsersManagementModel usersManagementModel = new UsersManagementModelManger(manageUserClient);
        RoomManagementModel roomManagementModel= new RoomManagementModelManage(manageRoomClient);
        ViewModelFactory viewModelFactory = new ViewModelFactory(usersManagementModel,roomManagementModel,loginModel,bookingModel);
        ViewHandler viewHandler = new ViewHandler(primaryStage,viewModelFactory,usersManagementModel,roomManagementModel, loginModel, bookingModel, currentUser);
        viewHandler.start();
        primaryStage.getOnCloseRequest();
    }


}
