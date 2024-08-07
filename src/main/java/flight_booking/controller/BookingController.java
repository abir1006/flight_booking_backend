package flight_booking.controller;

import flight_booking.controller.genericcontroller.GenericController;
import flight_booking.dto.BookingDto;
import flight_booking.service.BookingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController extends GenericController<Long, BookingDto> {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        super(bookingService);
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public ResponseEntity<BookingDto> bookFlight(@RequestBody BookingDto bookingDto) {
        BookingDto createdBooking = bookingService.bookFlight(bookingDto);
        return ResponseEntity.ok(createdBooking);
    }

    @DeleteMapping("/cancel/{bookingId}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/confirm/{bookingId}")
    public ResponseEntity<BookingDto> confirmBooking(@PathVariable Long bookingId) {
        BookingDto confirmedBooking = bookingService.confirmBooking(bookingId);
        return ResponseEntity.ok(confirmedBooking);
    }

    @GetMapping("/ticket/{bookingId}")
    public ResponseEntity<String> generateTicket(@PathVariable Long bookingId) {
        String ticket = bookingService.generateTicket(bookingId);
        return ResponseEntity.ok(ticket);
    }
    @PutMapping("/updateBooking/{id}")
    public ResponseEntity<BookingDto> updateBooking(@PathVariable Long id, @RequestBody BookingDto bookingDto) {
        BookingDto updatedBooking = bookingService.updateBooking(id, bookingDto);
        return ResponseEntity.ok(updatedBooking);
    }
    @GetMapping("/by-passenger-email")
    public ResponseEntity<Page<BookingDto>> getBookingsByPassengerEmail(
            @RequestParam String email,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<BookingDto> bookings = bookingService.getBookingsByPassengerEmail(email, pageable);
        return ResponseEntity.ok(bookings);
    }
}
