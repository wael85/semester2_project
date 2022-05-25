package model.inputValidation;

import javafx.scene.control.Alert;

public class ValidatorBooking {

    public static void notificationPopup(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
