package flight_booking.service;



import flight_booking.dto.BookingDto;
import jakarta.transaction.Transactional;


public interface BookingService extends GenericService<Long, BookingDto> {
    BookingDto bookFlight(BookingDto bookingDTO);
    BookingDto cancelBooking(Long bookingId);
    String generateTicket(Long bookingId);

    @Transactional
    BookingDto confirmBooking(Long bookingId);
    // Additional methods specific to Booking  here
}

