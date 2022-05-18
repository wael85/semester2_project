package viewModel.booking;

import model.booking.BookingModel;

public class TeacherBookingViewModel {
    private BookingModel bookingModel;

    public  TeacherBookingViewModel(BookingModel bookingModel){
        this.bookingModel = bookingModel;
        // bookingModel.addPropertyChangeListener("getAvailableRooms",evt -> );
    }
}
