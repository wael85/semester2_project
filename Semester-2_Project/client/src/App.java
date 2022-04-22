import client.ManageUserClient;
import client.ManageUserClientInterface;
import javafx.application.Application;
import javafx.stage.Stage;
import users_model.UsersManagementModel;
import users_model.UsersManagementModelManger;
import view.ViewHandler;
import viewModel.ViewModelFactory;


import java.rmi.registry.Registry;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ManageUserClientInterface client = new ManageUserClient("localhost", Registry.REGISTRY_PORT);
        UsersManagementModel usersManagementModel = new UsersManagementModelManger(client);
        ViewModelFactory viewModelFactory = new ViewModelFactory(usersManagementModel);
        ViewHandler viewHandler = new ViewHandler(primaryStage,viewModelFactory,usersManagementModel);
        viewHandler.start();
        primaryStage.getOnCloseRequest();
    }


}
