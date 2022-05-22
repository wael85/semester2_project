package server;

import database.BookingDAO;
import database.BookingImp;

import java.sql.SQLException;

public class CleanOldBooking implements Runnable {
    private BookingDAO bookingDAO;

    public CleanOldBooking() throws SQLException {
        this.bookingDAO = BookingImp.getInstance();
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1800000);
                bookingDAO.removeDeActiveBooking();
            } catch (InterruptedException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
