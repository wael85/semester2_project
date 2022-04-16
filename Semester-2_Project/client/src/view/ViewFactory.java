package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import view.manageUser.AddAdminController;
import view.manageUser.AddGuestController;
import view.manageUser.AddStudentController;
import view.manageUser.AddTeacherController;
import viewModel.ViewModelFactory;

import java.io.IOException;

public class ViewFactory {

    private ViewModelFactory viewModelFactory;
    private ViewHandler viewHandler;
    private AddAdminController addAdminController;
    private AddTeacherController addTeacherController;
    private AddGuestController addGuestController;
    private AddStudentController addStudentController;

    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory){
        this.viewHandler=viewHandler;
        this.viewModelFactory=viewModelFactory;
        this.addAdminController = null;
        this.addGuestController = null;
        this.addStudentController = null;
        this.addTeacherController = null;

    }


    public Region loadAddAdminView() {
        if (addAdminController==null){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/manageUser/addAdmin.fxml"));
            try {
                Region root= loader.load();
                addAdminController= loader.getController();
                addAdminController.init(viewHandler,viewModelFactory.getAddAdminViewModel(),root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return addAdminController.getRoot();
    }

    public Region loadAddStudentView() {
        if (addStudentController==null){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/manageUser/addStudent.fxml"));
            try {
                Region root= loader.load();
                addStudentController= loader.getController();
                addStudentController.init(viewHandler,viewModelFactory.getAddStudentViewModel(),root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return addStudentController.getRoot();
    }

    public Region loadAddGuestView() {
        if (addGuestController==null){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/manageUser/addGuest.fxml"));
            try {
                Region root= loader.load();
                addGuestController= loader.getController();
                addGuestController.init(viewHandler,viewModelFactory.getAddGuestViewModel(),root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return addGuestController.getRoot();
    }

    public Region loadAddTeacherView() {
        if (addTeacherController==null){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/manageUser/addTeacher.fxml"));
            try {
                Region root= loader.load();
                addTeacherController= loader.getController();
                addTeacherController.init(viewHandler,viewModelFactory.getAddTeacherViewModel(),root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return addTeacherController.getRoot();
    }
}
