package viewModel.booking;

import booking.Booking;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import model.booking.BookingModel;

import java.rmi.RemoteException;

public class StudentManageBookingViewModel {
    private BookingModel bookingModel;
    private ObservableList<Booking> bookingsObList;
    private StringProperty error;


    public  StudentManageBookingViewModel(BookingModel bookingModel){
        this.bookingModel = bookingModel;
        bookingsObList = FXCollections.observableArrayList();
        error = new SimpleStringProperty("");
    }
    public void bindError(StringProperty property){
        property.bind(error);
    }
    public ObservableList<Booking> getBookingsObList(){
        bookingsObList.clear();
        try {
            bookingsObList.addAll(bookingModel.getUserBooking().getBookingList());
            error.set("");
        } catch (RemoteException e) {
            error.set("");
            error.set(e.getMessage());
        }
        return bookingsObList;
    }
    public void cancelBooking(Booking b){
        try {
            bookingModel.cancelBooking(b);
            error.set("");
        }catch (RemoteException e){
            error.set("");
            error.set(e.getMessage());
        }
    }
    public void checkIn(Booking booking){
        try {
            bookingModel.checkIn(booking);
            error.set("");
        }catch (RemoteException r){
           error.set("");
           error.set(r.getMessage());
        }
    }
}
