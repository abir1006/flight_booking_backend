package flight_booking.service;



import flight_booking.dto.BookingDto;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BookingService extends GenericService<Long, BookingDto> {
    BookingDto bookFlight(BookingDto bookingDTO);
    BookingDto cancelBooking(Long bookingId);
    String generateTicket(Long bookingId);
    BookingDto confirmBooking(Long bookingId);
    BookingDto updateBooking(Long bookingId, BookingDto bookingDto);
    Page<BookingDto> getBookingsByPassengerEmail(String email, Pageable pageable);
    // Additional methods specific to Booking  here
}

