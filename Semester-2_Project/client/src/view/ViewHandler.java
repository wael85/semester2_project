package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.LoginModel;
import room_model.RoomManagementModel;
import user_state.UserState;
import users_model.UsersManagementModel;
import view.login.LoginController;
import view.mainMenu.MainMenuController;
import view.manageRooms.ManageRoomsController;
import view.manageUser.TabPaneManageUserController;
import view.booking.*;
import viewModel.ViewModelFactory;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private ViewModelFactory vmf;
    private UsersManagementModel usersManagementModel;
    private RoomManagementModel roomManagementModel;
    private LoginModel loginModel;
    private UserState currentUser;

    public ViewHandler(Stage stage, ViewModelFactory vmf, UsersManagementModel usersManagementModel,RoomManagementModel roomManagementModel,LoginModel loginModel, UserState currentUser) {
        this.stage = stage;
        this.vmf = vmf;
        this.usersManagementModel = usersManagementModel;
        this.roomManagementModel = roomManagementModel;
        this.loginModel = loginModel;
        this.currentUser = currentUser;
    }

    public void start() {
       openLogin();
    }

    public UserState getCurrentUser() {
        return currentUser;
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
                    loginModel.close();
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
                    loginModel.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openLogin(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/login/Login.fxml"));
            Parent root=loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Login");
            LoginController loginController = loader.getController();
            loginController.init(vmf.getLoginViewModel(), this);
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> {
                try {
                    usersManagementModel.close();
                    roomManagementModel.close();
                    loginModel.close();
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
                    loginModel.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openStudentBooking() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/booking/StudentBooking.fxml"));
            Parent root=loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Student Booking");
            StudentBookingController studentBookingController = loader.getController();
            studentBookingController.init( this);
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> {
                try {
                    usersManagementModel.close();
                    roomManagementModel.close();
                    loginModel.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openTeacherBooking() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/booking/TeacherBooking.fxml"));
            Parent root=loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Teacher Booking");
            TeacherBookingController teacherBookingController = loader.getController();
            teacherBookingController.init( this);
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> {
                try {
                    usersManagementModel.close();
                    roomManagementModel.close();
                    loginModel.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openGuestBooking() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/booking/GuestBooking.fxml"));
            Parent root=loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Guest Booking");
            GuestBookingController guestBookingController = loader.getController();
            guestBookingController.init( this);
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> {
                try {
                    usersManagementModel.close();
                    roomManagementModel.close();
                    loginModel.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
