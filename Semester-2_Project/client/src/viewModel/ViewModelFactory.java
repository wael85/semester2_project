package viewModel;


import users_model.UsersManagementModel;
import viewModel.administrator.ManageAdminViewModel;
import viewModel.administrator.ManageGuestViewModel;
import viewModel.administrator.ManageStudentViewModel;
import viewModel.administrator.ManageTeacherViewModel;

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
