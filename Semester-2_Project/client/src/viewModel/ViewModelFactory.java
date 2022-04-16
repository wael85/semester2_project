package viewModel;

import model.Model;


public class ViewModelFactory {

    private AddAdminViewModel addAdminViewModel;
    private AddStudentViewModel addStudentViewModel;
    private AddGuestViewModel addGuestViewModel;
    private AddTeacherViewModel addTeacherViewModel;

    public ViewModelFactory(Model model){
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
