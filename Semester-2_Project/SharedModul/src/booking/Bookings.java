package booking;

import java.util.ArrayList;

public class Bookings {
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
