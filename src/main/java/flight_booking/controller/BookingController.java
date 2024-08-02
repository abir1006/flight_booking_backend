package flight_booking.controller;




import flight_booking.controller.genericcontroller.GenericController;
import flight_booking.dto.BookingDto;
import flight_booking.service.BookingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController extends GenericController<Long, BookingDto> {

    public BookingController(BookingService service) {
        super(service);
    }
    // Additional Booking-specific endpoints can be defined here
}
