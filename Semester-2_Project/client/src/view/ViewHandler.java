package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import users_model.UsersManagementModel;
import view.mainMenu.MainMenuController;
import view.manageRooms.ManageRoomsController;
import view.manageUser.TabPaneManageUserController;
import viewModel.ViewModelFactory;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private ViewModelFactory vmf;
    private UsersManagementModel usersManagementModel;

    public ViewHandler(Stage stage, ViewModelFactory vmf, UsersManagementModel usersManagementModel) {
        this.stage = stage;
        this.vmf = vmf;
        this.usersManagementModel = usersManagementModel;
    }

    public void start() {
       openMainMenu();
    }

    public void openTabPaneManageUser() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/manageUser/tabPaneManageUser.fxml"));
            Parent root = loader.load();

            TabPaneManageUserController view = loader.getController();
            view.init(vmf,this);
            Scene scene = new Scene(root);
            stage.setTitle("Manage User");

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(e -> {
                try {
                    usersManagementModel.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openMainMenu() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/mainMenu/MainMenu.fxml"));
          Parent root=loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Main Menu");
            MainMenuController mainMenuController = loader.getController();
            mainMenuController.init(vmf, this);
            stage.setScene(scene);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void closeView(){
        stage.close();

    }
    public void openManageRoom(){

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/manageRooms/ManageRooms.fxml"));
            Parent root=loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Manage Rooms");
            ManageRoomsController manageRoomsController = loader.getController();
            manageRoomsController.init(vmf, this);
            stage.setScene(scene);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
