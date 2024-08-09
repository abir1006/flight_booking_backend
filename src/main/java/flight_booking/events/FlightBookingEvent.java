package flight_booking.events;

import flight_booking.domain.Booking;
import org.springframework.context.ApplicationEvent;

public class FlightBookingEvent extends ApplicationEvent {
    private Booking booking;

    public FlightBookingEvent(Object source, Booking booking) {
        super(source);
        this.booking = booking;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
