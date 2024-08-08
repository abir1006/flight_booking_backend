package flight_booking.controller;


import flight_booking.domain.Booking;
import flight_booking.dto.BookingDto;
import flight_booking.repositories.BookingRepository;
import flight_booking.service.BookingService;
import flight_booking.service.EmailSenderService;
import flight_booking.service.PdfGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {
    @Autowired
    EmailSenderService emailSenderService;


    @Autowired
    PdfGenerationService pdfGenerationService;

    @PostMapping("/reserved")
    public String sendEmailReserved(@RequestParam long bookingId) throws Exception {

        emailSenderService.sendEmailWithoutPdf(bookingId);
        return "Email sent successfully";

    }

    @PostMapping("/confirmed")
    public String sendConfirmationEmail(@RequestParam long bookingId) throws Exception {

        emailSenderService.sendEmailWithPdf(bookingId);
        return "Email sent successfully";

    }

    @GetMapping("/confirmed/ticket/{bookingId}")
    public ResponseEntity<ByteArrayResource> getBookingTicket(@PathVariable long bookingId) {
        try {
            byte[] pdfBytes = pdfGenerationService.generateTicketPdf(bookingId);

            ByteArrayResource resource = new ByteArrayResource(pdfBytes);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=e-ticket.pdf");
            headers.setContentType(MediaType.APPLICATION_PDF);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(pdfBytes.length)
                    .body(resource);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
