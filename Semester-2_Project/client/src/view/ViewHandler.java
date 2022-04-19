package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.addUser.TabPaneAdminController;
import viewModel.ViewModelFactory;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private ViewModelFactory vmf;

    public ViewHandler(Stage stage, ViewModelFactory vmf) {
        this.stage = stage;
        this.vmf = vmf;
    }

    public void start() {
        openTabPaneAdmin();
    }

    private void openTabPaneAdmin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/addUser/tabPaneAdmin.fxml"));
            Parent root = loader.load();

            TabPaneAdminController view = loader.getController();
            view.init(vmf);
            Scene scene = new Scene(root);
            stage.setTitle("");

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void closeView(){
        stage.close();

    }

}
