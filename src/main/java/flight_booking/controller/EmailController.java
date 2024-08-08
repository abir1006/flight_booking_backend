package flight_booking.controller;


import flight_booking.domain.Booking;
import flight_booking.dto.BookingDto;
import flight_booking.repositories.BookingRepository;
import flight_booking.service.BookingService;
import flight_booking.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {
    @Autowired
    EmailSenderService emailSenderService;

    @Autowired
    BookingRepository repository;

    @PostMapping("/reserved")
    public String sendEmailReserved(@RequestParam  String to,
                            @RequestParam long bookingId) throws Exception {

        emailSenderService.sendEmailWithoutPdf(to,bookingId);
        return "Email sent successfully";

    }

    @PostMapping("/confirmed")
    public String sendConfirmationEmail(@RequestParam  String to,
                            @RequestParam long bookingId) throws Exception {

        emailSenderService.sendEmailWithPdf(to,bookingId);
        return "Email sent successfully";

    }

}
