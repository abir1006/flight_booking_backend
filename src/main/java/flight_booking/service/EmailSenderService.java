package flight_booking.service;

import com.itextpdf.text.DocumentException;
import flight_booking.domain.Booking;
import flight_booking.domain.Passenger;
import flight_booking.repositories.PassengerRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PdfGenerationService pdfGenerationService;

    @Autowired
    private PassengerRepository repository;

    public void sendEmailWithPdf(String to, String subject,  Booking booking) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        //get main passenger to send mail
//        Passenger mainPassenger = getMainPassenger(booking);
        String body = "Hi, %s Your booking  for flight# %s has been Confirmed, Enjoy your flight" ;


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

    public void sendEmailWithoutPdf(String to, String subject, Booking booking) throws Exception {

        SimpleMailMessage message = new SimpleMailMessage();

        String body="Hi, %s Your booking  for flight# %s has been reserved \nPlease go to the payment section to confirm your booking";
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);

    }


//    public Passenger getMainPassenger(Booking booking)
//    {
//        List<Passenger> passengers = booking.getPassengers();
//        Passenger mainPassenger = new Passenger();
//        for(Passenger passenger : passengers) {
//            mainPassenger=repository.findByEmail(passenger.getEmail());
//        }
//        return mainPassenger;
//
//    }
}
