package flight_booking.service;


import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import flight_booking.domain.Booking;
import flight_booking.domain.Passenger;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfGenerationService {

    public byte[] generateTicketPdf(Booking booking) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);


        document.open();
        document.add(new Paragraph("\t\t\tE-Ticket"));
        document.add(new Paragraph("Flight Booking Ticket"));
        document.add(new Paragraph("Booking ID: " + booking.getId()));
//      document.add(new Paragraph("Booking Date: " + booking.getBookingDate().toString()));
        document.add(new Paragraph("Trip Type: " + booking.getTripType()));
        document.add(new Paragraph("Amount Paid: " + booking.getTotalPrice()));
        document.add(new Paragraph("\nPassenger Details"));

        PdfPTable table = new PdfPTable(4);
        table.addCell("First Name");
        table.addCell("Last Name");
        table.addCell("Email");
        table.addCell("Phone");


        for (Passenger passenger : booking.getPassengers()) {
            table.addCell(passenger.getFirstName());
            table.addCell(passenger.getLastName());
            table.addCell(passenger.getEmail());
            table.addCell(passenger.getPhone());
        }

        document.add(table);
        document.close();

        return outputStream.toByteArray();
    }
}
