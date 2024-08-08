package flight_booking.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import flight_booking.domain.Booking;
import flight_booking.domain.Passenger;
import flight_booking.dto.BookingDto;
import flight_booking.dto.PassengerDto;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;

@Service
public class PdfGenerationService {

    public byte[] generateTicketPdf(Booking booking) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);

        // Set document properties
        document.addAuthor("Flight Booking Service");
        document.addCreationDate();
        document.addTitle("E-Ticket");

        document.open();

        // Add title
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.BLUE);
        Paragraph title = new Paragraph("E-Ticket", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        // Add booking information
        Font infoFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
        document.add(new Paragraph("\nFlight Booking Ticket", infoFont));
        document.add(new Paragraph("Booking ID: " + booking.getId(), infoFont));
      document.add(new Paragraph("Booking Date: " + LocalDate.now() ,infoFont));
        document.add(new Paragraph("Departure Date: " + booking.getFlight().getFlightSchedule().getDepartureDate() ,infoFont));
        if(booking.getTripType().equals("ROUND_TRIP")){
            document.add(new Paragraph("Return Date: " + booking.getReturnDate() ,infoFont));
        }
        document.add(new Paragraph("Trip Type: " + booking.getTripType(), infoFont));
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
}
