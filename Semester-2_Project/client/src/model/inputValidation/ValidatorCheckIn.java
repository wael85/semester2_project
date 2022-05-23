package model.inputValidation;

import booking.Booking;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ValidatorCheckIn {

    private static void illegalArgument(String message) {
        throw new IllegalArgumentException(message);
    }
    public static void validateCheckIn(Booking booking){

        LocalDateTime now = LocalDateTime.now();

        //todo check the month in controller and viewModel

        Timestamp timestamp= new Timestamp(now.getYear()-1900,now.getMonthValue()-1,now.getDayOfMonth(), now.getHour(), now.getMinute(), 0,0);





       if (timestamp.before(booking.getStartDateTime())){

           illegalArgument("Check in still not available");

       }
    }


}
