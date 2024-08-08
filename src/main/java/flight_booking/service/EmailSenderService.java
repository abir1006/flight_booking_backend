package flight_booking.service;


import flight_booking.domain.Booking;
import flight_booking.domain.Passenger;
import flight_booking.domain.User;
import flight_booking.repositories.BookingRepository;
import flight_booking.repositories.UserRepository;
import jakarta.mail.internet.MimeMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@EnableAsync
@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PdfGenerationService pdfGenerationService;

    @Autowired
    private UserRepository repository;

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Value("${sendingEmail}")
    private  String sendingEmail;

    public void sendEmailWithPdf(long bookingId) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // Get main passenger to send mail
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        Booking booking = optionalBooking.orElse(null);

        assert booking != null;
        List<String> emails = booking.getPassengers().stream().map(Passenger::getEmail).toList();
        User passenger = getMainPassenger(emails);

        assert passenger != null;
        String body = String.format("""
                        Hi %s,

                        We are pleased to inform you that your booking for flight #%s  has been confirmed. \
                        Please find your e-ticket attached to this email.

                        Thank you for choosing our service. We wish you a pleasant journey!
                        
                        *******Booking Information*****
                        ReservedDate:%s
                        AirlinesName:%s
                        DepartureDate:%s
                        Departure: %s
                        Arrival: %s

                        Best regards,
                        Flight Booking Service""",
                passenger.getFirstname() + " " + passenger.getLastname(),
                booking.getFlight().getId(),
                booking.getBookingDate(),
                booking.getFlight().getAirline().getAirlineName(),
                booking.getFlight().getFlightSchedule().getDepartureDate(),
                booking.getFlight().getDepartureAirport().getCity(),
                booking.getFlight().getArrivalAirport().getCity());

        helper.setFrom(sendingEmail);
        helper.setTo(passenger.getEmail());
        helper.setSubject("Booking Reserved!");
        helper.setText(body);

        // Generate PDF in memory
//        BookingDto bookingDto=modelMapper.map(booking, BookingDto.class);
        byte[] pdfBytes = pdfGenerationService.generateTicketPdf(bookingId);

        // Attach PDF
        InputStreamSource pdfSource = new ByteArrayResource(pdfBytes);
        helper.addAttachment("e-ticket.pdf", pdfSource, "application/pdf");

        mailSender.send(message);
    }

    public void sendEmailWithoutPdf(long bookingId) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();

        // Get main passenger to send mail
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        Booking booking = optionalBooking.orElse(null);

        assert booking != null;
        List<String> emails = booking.getPassengers().stream().map(Passenger::getEmail).toList();
        User passenger = getMainPassenger(emails);

        assert passenger != null;
        String body = String.format("""
                        Hi %s,

                        Your booking for flight #%s has been reserved. \
                        Please make the payment to confirm your booking.

                        Thank you for choosing our service. We look forward to serving you!
                        
                        *******Booking Information*****
                        ReservedDate:%s
                        AirlinesName:%s
                        DepartureDate:%s
                        Departure: %s
                        Arrival: %s

                        Best regards,
                        Flight Booking Service""",
                passenger.getFirstname() +" "+ passenger.getLastname(),
                booking.getFlight().getId(),
                booking.getBookingDate(),
                booking.getFlight().getAirline().getAirlineName(),
                booking.getFlight().getFlightSchedule().getDepartureDate(),
                booking.getFlight().getDepartureAirport().getCity(),
                booking.getFlight().getArrivalAirport().getCity());

        message.setFrom(sendingEmail);
        message.setTo(passenger.getEmail());
        message.setSubject("Booking Confirmed");
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
