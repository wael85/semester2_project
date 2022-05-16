package viewModel;


import model.login.LoginModel;
import model.booking.BookingModel;
import model.rooms.RoomManagementModel;
import model.users_mangment.UsersManagementModel;
import viewModel.login.LoginViewModel;
import viewModel.manageRooms.ManageRoomsViewModel;
import viewModel.manageUsers.ManageAdminViewModel;
import viewModel.manageUsers.ManageGuestViewModel;
import viewModel.manageUsers.ManageStudentViewModel;
import viewModel.manageUsers.ManageTeacherViewModel;

public class ViewModelFactory {

    private ManageAdminViewModel manageAdminViewModel;
    private ManageStudentViewModel manageStudentViewModel;
    private ManageGuestViewModel manageGuestViewModel;
    private ManageTeacherViewModel manageTeacherViewModel;
    private ManageRoomsViewModel manageRoomsViewModel;
    private LoginViewModel loginViewModel;

    public ViewModelFactory(UsersManagementModel usersModel, RoomManagementModel roomModel, LoginModel loginModel, BookingModel bookingModel){
        this.manageAdminViewModel =new ManageAdminViewModel(usersModel);
        this.manageGuestViewModel = new ManageGuestViewModel(usersModel);
        this.manageStudentViewModel = new ManageStudentViewModel(usersModel);
        this.manageTeacherViewModel = new ManageTeacherViewModel(usersModel);
        this.manageRoomsViewModel = new ManageRoomsViewModel(roomModel);
        this.loginViewModel = new LoginViewModel(loginModel);
    }

    public ManageAdminViewModel getManageAdminViewModel() {
        return manageAdminViewModel;
    }

    public ManageStudentViewModel getManageStudentViewModel() {
        return manageStudentViewModel;
    }

    public ManageGuestViewModel getManagGuestViewModel() {
        return manageGuestViewModel;
    }

    public ManageTeacherViewModel getManageTeacherViewModel() {
        return manageTeacherViewModel;
    }

    public ManageRoomsViewModel getManageRoomsViewModel(){
        return manageRoomsViewModel;
    }

    public LoginViewModel getLoginViewModel(){
        return loginViewModel;
    }
}
