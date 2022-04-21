package booking;

import java.sql.Timestamp;
import java.util.Date;

public class Booking {
    private int id;
    private String bookedBy;
    private String roomId;
    private Timestamp startDateTime;
    private Timestamp endDateTime;
    private Timestamp firstReminder;
    private Timestamp lastReminder;
    private boolean isCheckedIn;
    private BookingStatus status;

    public Booking(int id, String bookedBy, String roomId, Timestamp startDateTime, Timestamp endDateTime) {
        this.id = id;
        this.bookedBy = bookedBy;
        this.roomId = roomId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.firstReminder = new Timestamp(startDateTime.getTime() - 300000) ;
        this.lastReminder = new Timestamp(endDateTime.getTime() + 1500000 );
        this.isCheckedIn = false;
        this.status = BookingStatus.PRE_ACTIVE;
    }

    public Timestamp getFirstReminder() {
        return firstReminder;
    }

    public static void main(String[] args) {
        Booking y = new Booking(1,"wer","wr",new Timestamp(2022-1900,4,12,10,0,3,0),new Timestamp(2022,4,12,13,0,0,0));
        System.out.println(y.getFirstReminder().toLocaleString());
    }
}
