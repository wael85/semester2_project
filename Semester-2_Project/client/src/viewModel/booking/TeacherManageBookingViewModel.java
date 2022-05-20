package viewModel.booking;

import booking.Booking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.booking.BookingModel;
import java.rmi.RemoteException;

public class TeacherManageBookingViewModel {
    private BookingModel bookingModel;
    private ObservableList<Booking> bookingsObList;


    public TeacherManageBookingViewModel(BookingModel bookingModel){
        this.bookingModel = bookingModel;
        bookingsObList = FXCollections.observableArrayList();
    }
    public ObservableList<Booking> getBookingsObList(){
        bookingsObList.clear();
        try {
            bookingsObList.addAll(bookingModel.getUserBooking().getBookingList());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return bookingsObList;
    }
    public void cancelBooking(Booking b){
        try {
            bookingModel.cancelBooking(b);
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }
}
