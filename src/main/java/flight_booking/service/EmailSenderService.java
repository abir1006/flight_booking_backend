package flight_booking.service;

import com.itextpdf.text.DocumentException;
import flight_booking.domain.Booking;
import flight_booking.domain.Passenger;
import flight_booking.domain.Role;
import flight_booking.domain.User;
import flight_booking.dto.BookingDto;
import flight_booking.dto.PassengerDto;
import flight_booking.repositories.PassengerRepository;
import flight_booking.repositories.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@EnableAsync
@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PdfGenerationService pdfGenerationService;

    @Autowired
    private UserRepository repository;

    public void sendEmailWithPdf(String to, String subject, BookingDto booking) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // Get main passenger to send mail
        List<String> emails = booking.getPassengers().stream().map(PassengerDto::getEmail).toList();
        User passenger = getMainPassenger(emails);

        assert passenger != null;
        String body = String.format("""
                        Hi %s,

                        We are pleased to inform you that your booking for flight #%s has been confirmed. \
                        Please find your e-ticket attached to this email.

                        Thank you for choosing our service. We wish you a pleasant journey!

                        Best regards,
                        Flight Booking Service""",
                passenger.getFirstname(), booking.getFlightId());

        helper.setFrom("no-reply@flightbooking.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body);

        // Generate PDF in memory
        byte[] pdfBytes = pdfGenerationService.generateTicketPdf(booking);

        // Attach PDF
        InputStreamSource pdfSource = new ByteArrayResource(pdfBytes);
        helper.addAttachment("e-ticket.pdf", pdfSource, "application/pdf");

        mailSender.send(message);
    }

    public void sendEmailWithoutPdf(String to, String subject, BookingDto booking) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();

        // Get main passenger to send mail
        List<String> emails = booking.getPassengers().stream().map(PassengerDto::getEmail).toList();
        User passenger = getMainPassenger(emails);

        assert passenger != null;
        String body = String.format("""
                        Hi %s,

                        Your booking for flight #%s has been reserved. \
                        Please go to the payment section to confirm your booking.

                        Thank you for choosing our service. We look forward to serving you!

                        Best regards,
                        Flight Booking Service""",
                passenger.getFirstname(), booking.getFlightId());

        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }

    private User getMainPassenger(List<String> emails) {
        for (String email : emails) {
            User mainPassenger = repository.findByEmail(email).orElse(null);
            if (mainPassenger != null) {
                return mainPassenger;
            }
        }
        return null;
    }
}
