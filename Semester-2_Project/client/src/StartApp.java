import clients_classes.ManageUserClient;
import clients_classes.ManageUserClientInterface;
import javafx.application.Application;
import javafx.stage.Stage;
import users_model.UsersManagementModel;
import users_model.UsersManagementModelManger;
import view.ViewHandler;
import viewModel.ViewModelFactory;

import java.rmi.registry.Registry;

public class StartApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ManageUserClientInterface client = new ManageUserClient("localhost", Registry.REGISTRY_PORT);
        UsersManagementModel usersManagementModel = new UsersManagementModelManger(client);
        ViewModelFactory viewModelFactory = new ViewModelFactory(usersManagementModel);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}
