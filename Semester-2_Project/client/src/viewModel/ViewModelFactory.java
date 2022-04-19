package viewModel;


import model.UsersManagementModel;
import viewModel.administrator.AddAdminViewModel;
import viewModel.administrator.AddGuestViewModel;
import viewModel.administrator.AddStudentViewModel;
import viewModel.administrator.AddTeacherViewModel;

public class ViewModelFactory {

    private AddAdminViewModel addAdminViewModel;
    private AddStudentViewModel addStudentViewModel;
    private AddGuestViewModel addGuestViewModel;
    private AddTeacherViewModel addTeacherViewModel;

    public ViewModelFactory(UsersManagementModel model){
        this.addAdminViewModel =new AddAdminViewModel(model);
        this.addGuestViewModel = new AddGuestViewModel(model);
        this.addStudentViewModel = new AddStudentViewModel(model);
        this.addTeacherViewModel = new AddTeacherViewModel(model);
    }

    public AddAdminViewModel getAddAdminViewModel() {
        return addAdminViewModel;
    }

    public AddStudentViewModel getAddStudentViewModel() {
        return addStudentViewModel;
    }

    public AddGuestViewModel getAddGuestViewModel() {
        return addGuestViewModel;
    }

    public AddTeacherViewModel getAddTeacherViewModel() {
        return addTeacherViewModel;
    }
}
