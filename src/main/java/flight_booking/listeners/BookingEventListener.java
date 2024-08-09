package flight_booking.listeners;

import flight_booking.events.FlightBookingEvent;
import flight_booking.service.EmailSenderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
@Transactional
public class BookingEventListener {

    @Autowired
    EmailSenderService emailSenderService;

    @Async
    @EventListener
    public void handleBookingEvent(FlightBookingEvent flightBookingEvent) throws Exception {
        // Sending booking confirmation email.
        emailSenderService.sendEmailWithPdf(flightBookingEvent.getBooking().getId());
    }
}
