package viewModel;


import model.login.LoginModel;
import model.booking.BookingModel;
import model.rooms.RoomManagementModel;
import model.users_mangment.UsersManagementModel;
import viewModel.booking.*;
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
    private GuestManageBookingViewModel guestManageBookingViewModel;
    private GuestBookingViewModel guestBookingViewModel;
    private StudentManageBookingViewModel studentManageBookingViewModel;
    private StudentBookingViewModel studentBookingViewModel;
    private TeacherManageBookingViewModel teacherManageBookingViewModel;
    private TeacherBookingViewModel teacherBookingViewModel;
    private CheckInViewModel checkInViewModel;


    public ViewModelFactory(UsersManagementModel usersModel, RoomManagementModel roomModel, LoginModel loginModel, BookingModel bookingModel){
        this.manageAdminViewModel =new ManageAdminViewModel(usersModel);
        this.manageGuestViewModel = new ManageGuestViewModel(usersModel);
        this.manageStudentViewModel = new ManageStudentViewModel(usersModel);
        this.manageTeacherViewModel = new ManageTeacherViewModel(usersModel);
        this.manageRoomsViewModel = new ManageRoomsViewModel(roomModel);
        this.loginViewModel = new LoginViewModel(loginModel);
        this.guestBookingViewModel = new GuestBookingViewModel(bookingModel);
        this.guestManageBookingViewModel = new GuestManageBookingViewModel(bookingModel);
        this.teacherBookingViewModel = new TeacherBookingViewModel(bookingModel);
        this.teacherManageBookingViewModel = new TeacherManageBookingViewModel(bookingModel);
        this.studentBookingViewModel = new StudentBookingViewModel(bookingModel);
        this.studentManageBookingViewModel = new StudentManageBookingViewModel(bookingModel);
        this.checkInViewModel = new CheckInViewModel(bookingModel);

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

    public ManageGuestViewModel getManageGuestViewModel() {
        return manageGuestViewModel;
    }

    public GuestManageBookingViewModel getGuestManageBookingViewModel() {
        return guestManageBookingViewModel;
    }

    public GuestBookingViewModel getGuestBookingViewModel() {
        return guestBookingViewModel;
    }

    public StudentManageBookingViewModel getStudentManageBookingViewModel() {
        return studentManageBookingViewModel;
    }

    public StudentBookingViewModel getStudentBookingViewModel() {
        return studentBookingViewModel;
    }

    public TeacherManageBookingViewModel getTeacherManageBookingViewModel() {
        return teacherManageBookingViewModel;
    }

    public TeacherBookingViewModel getTeacherBookingViewModel() {
        return teacherBookingViewModel;
    }

    public CheckInViewModel getCheckInViewModel() {
        return checkInViewModel;
    }
}
