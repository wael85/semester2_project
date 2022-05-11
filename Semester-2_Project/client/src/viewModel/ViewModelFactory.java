package viewModel;


import users_model.UsersManagementModel;
import viewModel.manageUsers.ManageAdminViewModel;
import viewModel.manageUsers.ManageGuestViewModel;
import viewModel.manageUsers.ManageStudentViewModel;
import viewModel.manageUsers.ManageTeacherViewModel;

public class ViewModelFactory {

    private ManageAdminViewModel manageAdminViewModel;
    private ManageStudentViewModel manageStudentViewModel;
    private ManageGuestViewModel manageGuestViewModel;
    private ManageTeacherViewModel manageTeacherViewModel;

    public ViewModelFactory(UsersManagementModel model){
        this.manageAdminViewModel =new ManageAdminViewModel(model);
        this.manageGuestViewModel = new ManageGuestViewModel(model);
        this.manageStudentViewModel = new ManageStudentViewModel(model);
        this.manageTeacherViewModel = new ManageTeacherViewModel(model);
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
}
