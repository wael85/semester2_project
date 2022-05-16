package booking;

import java.io.Serializable;
import java.util.ArrayList;

public class Bookings implements Serializable {
    private ArrayList<Booking> bookingList;

    public Bookings(){
        this.bookingList = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookingList.add(booking);
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "bookingList=" + bookingList +
                '}';
    }
}
