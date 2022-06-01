package model.inputValidation;

import javafx.scene.control.Alert;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ValidatorBooking {

    public static void notificationPopup(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText(msg);
        alert.showAndWait();
    }
    public static Boolean validatorTime(Date date, String start, String end ){
        boolean isDigit;
        for (int i = 0; i < start.length(); i++) {
            char ch = start.charAt(i);
            isDigit =  Character.isDigit(ch);
            if (!(isDigit)) {
                notificationPopup("Start time needs only digits!");

                return false;
            }
        }
        for (int i = 0; i < end.length(); i++) {
            char ch = end.charAt(i);
            isDigit =  Character.isDigit(ch);
            if (!(isDigit)) {
                notificationPopup("End time needs only digits!");
                return false;
            }
        }
        int s =Integer.parseInt(start);
        int e =Integer.parseInt(end);

        if (s>=e){
            notificationPopup("Check the time input");
            return false;
        }
        if (s>=24) {
            notificationPopup("Start time start from 00h to 23h ");
            return false;

        }else if (e>=25 ){
            notificationPopup("End time start from 01h to 24h ");
            return false;
        }
        LocalDateTime now = LocalDateTime.now();
        java.util.Date convertedDatetime = java.sql.Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        if (date.getDate()==convertedDatetime.getDate()){
            if (s<now.getHour()){
                int hour = now.getHour()+1;
                notificationPopup("can book today from "+hour);

                return false;
            }
        }

        return true;
    }
}
