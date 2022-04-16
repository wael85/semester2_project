package view;

import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewModel.ViewModelFactory;

public class ViewHandler {

    private Stage primaryStage;
    private final Scene currentScene;
    private final ViewFactory viewFactory;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewFactory= new ViewFactory(this,viewModelFactory);
        this.currentScene= new Scene(new Region());
    }
    public void start(Stage primaryStage){
        this.primaryStage=primaryStage;

        openView("addAdmin");
    }

    public void openView(String id){
        Region root = switch (id) {

            case "addAdmin" -> viewFactory.loadAddAdminView();
            case "addStudent" -> viewFactory.loadAddStudentView();
            case "addGuest" -> viewFactory.loadAddGuestView();
            case "addTeacher" -> viewFactory.loadAddTeacherView();
            default -> throw new IllegalArgumentException("Unknown view: " + id);
        };
        currentScene.setRoot(root);
        if (root.getUserData() == null) {
            primaryStage.setTitle("");
        } else {
            primaryStage.setTitle(root.getUserData().toString());
        }
        primaryStage.setScene(currentScene);
        primaryStage.sizeToScene();
        primaryStage.show();

    }
    public void closeView(){
        primaryStage.close();

    }

}
