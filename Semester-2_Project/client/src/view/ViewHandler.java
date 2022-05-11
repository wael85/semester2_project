package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import room_model.RoomManagementModel;
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
    private RoomManagementModel roomManagementModel;

    public ViewHandler(Stage stage, ViewModelFactory vmf, UsersManagementModel usersManagementModel,RoomManagementModel roomManagementModel) {
        this.stage = stage;
        this.vmf = vmf;
        this.usersManagementModel = usersManagementModel;
        this.roomManagementModel = roomManagementModel;
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
                    roomManagementModel.close();
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
            stage.setOnCloseRequest(e -> {
                try {
                    usersManagementModel.close();
                    roomManagementModel.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openManageRoom(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/manageRooms/ManageRooms.fxml"));
            Parent root=loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Manage Rooms");
            ManageRoomsController manageRoomsController = loader.getController();
            manageRoomsController.init(vmf.getManageRoomsViewModel(), this);
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> {
                try {
                    usersManagementModel.close();
                    roomManagementModel.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
