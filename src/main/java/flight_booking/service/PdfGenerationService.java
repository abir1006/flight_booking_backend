package flight_booking.service;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import flight_booking.domain.Booking;
import flight_booking.domain.Passenger;

import flight_booking.repositories.BookingRepository;
import flight_booking.repositories.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

@Service
public class PdfGenerationService {
    private static final Logger log = LoggerFactory.getLogger(PdfGenerationService.class);
    @Autowired
    BookingRepository bookingRepository;



    public byte[] generateTicketPdf(long bookingId) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);


        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        Booking booking = optionalBooking.orElse(null);
        assert booking!=null;

        document.open();
        // Set document properties
        document.addAuthor("Flight Booking Service");
        document.addCreationDate();
        document.addTitle("E-Ticket");

        // Add image (logo) from URL
        String logoUrl = booking.getFlight().getAirline().getAirlineLogo();
        Image image =  getImageFromUrl(logoUrl);
        if (image != null) {
            image.scaleToFit(200, 200); // Resize the logo
            image.setAlignment(Image.ALIGN_RIGHT);
            image.setBorder(1);
            document.add(image);
        }


        // Add title
        Font titleFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 20, BaseColor.BLUE);
        Paragraph title = new Paragraph("E-Ticket", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        // Add booking information
        Font infoFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
        document.add(new Paragraph("\nFlight Booking Ticket", infoFont));
        document.add(new Paragraph("Booking ID: " + booking.getId(), infoFont));
        document.add(new Paragraph("Trip Type: " + booking.getTripType(), infoFont));
        document.add(new Paragraph("Booking Date: " + booking.getBookingDate() ,infoFont));
        document.add(new Paragraph("Airline: " + booking.getFlight().getAirline().getAirlineName() ,infoFont));
        document.add(new Paragraph("Departure Date: " + booking.getFlight().getFlightSchedule().getDepartureDate() ,infoFont));
        document.add(new Paragraph("Departure Airport: " + booking.getFlight().getDepartureAirport().getName()+", "+ booking.getFlight().getDepartureAirport().getCity() ,infoFont));
        document.add(new Paragraph("Arrival Airport: " + booking.getFlight().getArrivalAirport().getName()+", "+ booking.getFlight().getArrivalAirport().getCity() ,infoFont));
        if(booking.getTripType().equals("ROUND_TRIP")){
            document.add(new Paragraph("Return Date: " + booking.getReturnDate() ,infoFont));
        }
        document.add(new Paragraph("Amount Paid: " + booking.getTotalPrice(), infoFont));

        document.add(new Paragraph("\nPassenger Details", titleFont));

        // Add table with passenger details
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        // Set table header
        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
        PdfPCell header;
        header = new PdfPCell(new Phrase("First Name", headFont));
        header.setBackgroundColor(BaseColor.BLUE);
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(header);

        header = new PdfPCell(new Phrase("Last Name", headFont));
        header.setBackgroundColor(BaseColor.BLUE);
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(header);

        header = new PdfPCell(new Phrase("Email", headFont));
        header.setBackgroundColor(BaseColor.BLUE);
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(header);

        header = new PdfPCell(new Phrase("Phone", headFont));
        header.setBackgroundColor(BaseColor.BLUE);
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(header);

        // Add table rows with passenger details
        Font rowFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
        for (Passenger passenger : booking.getPassengers()) {
            PdfPCell cell;

            cell = new PdfPCell(new Phrase(passenger.getFirstName(), rowFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(passenger.getLastName(), rowFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(passenger.getEmail(), rowFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(passenger.getPhone(), rowFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }

        document.add(table);
        document.close();

        return outputStream.toByteArray();
    }

    private Image getImageFromUrl(String logoUrl) {
        try {
            URL url = new URL(logoUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                return Image.getInstance(inputStream.readAllBytes());
            }
        } catch (Exception e) {
            log.error("Failed to fetch image from URL: " + logoUrl, e);
        }
        return null;
    }
}
