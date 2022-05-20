package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.booking.BookingModel;
import model.login.LoginModel;
import model.rooms.RoomManagementModel;
import user_state.UserState;
import model.users_mangment.UsersManagementModel;
import view.booking.guest.GuestTabViewController;
import view.booking.student.StudentTabViewController;
import view.booking.teacher.TeacherTabViewController;
import view.login.LoginController;
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
    private LoginModel loginModel;
    private BookingModel bookingModel;
    private UserState currentUser;

    public ViewHandler(Stage stage, ViewModelFactory vmf, UsersManagementModel usersManagementModel,RoomManagementModel roomManagementModel,LoginModel loginModel,BookingModel bookingModel, UserState currentUser) {
        this.stage = stage;
        this.vmf = vmf;
        this.usersManagementModel = usersManagementModel;
        this.roomManagementModel = roomManagementModel;
        this.loginModel = loginModel;
        this.currentUser = currentUser;
        this.bookingModel = bookingModel;
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
                    bookingModel.close();
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
                    bookingModel.close();
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
                    bookingModel.close();
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
                    bookingModel.close();
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
            loader.setLocation(getClass().getResource("../view/booking/student/StudentTabView.fxml"));
            Parent root=loader.load();

            StudentTabViewController studentTabViewController = loader.getController();
            studentTabViewController.init( this,vmf);

            Scene scene = new Scene(root);
            stage.setTitle("Student Booking");

            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(e -> {
                try {
                    usersManagementModel.close();
                    roomManagementModel.close();
                    loginModel.close();
                    bookingModel.close();
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
            loader.setLocation(getClass().getResource("../view/booking/teacher/TeacherTabView.fxml"));
            Parent root=loader.load();
            TeacherTabViewController teacherTabViewController = loader.getController();
            teacherTabViewController.init( this , vmf);

            Scene scene = new Scene(root);
            stage.setTitle("Teacher Booking");

            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> {
                try {
                    usersManagementModel.close();
                    roomManagementModel.close();
                    loginModel.close();
                    bookingModel.close();
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
            loader.setLocation(getClass().getResource("../view/booking/guest/GuestTabView.fxml"));
            Parent root=loader.load();
            GuestTabViewController guestTabViewController = loader.getController();
            guestTabViewController.init( this,vmf);
            Scene scene = new Scene(root);
            stage.setTitle("Guest Booking");
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> {
                try {
                    usersManagementModel.close();
                    roomManagementModel.close();
                    loginModel.close();
                    bookingModel.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
