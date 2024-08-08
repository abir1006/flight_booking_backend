package flight_booking.Util;
//
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//import com.itextpdf.layout.element.Cell;
//import flight_booking.domain.Booking;
//import flight_booking.domain.Passenger;
//
//import java.io.ByteArrayOutputStream;

public class PdfGenerator {
//    public static byte[] generateTicketPdf(Booking booking) {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        PdfWriter writer = new PdfWriter(byteArrayOutputStream);
//        Document document = new Document(new PdfDocument(writer));
//
//        document.add(new Paragraph("Flight Booking Ticket"));
//        document.add(new Paragraph("Booking ID: " + booking.getId()));
//        document.add(new Paragraph("Booking Date: " + booking.getBookingDate().toString()));
//        document.add(new Paragraph("Trip Type: " + booking.getTripType()));
//        document.add(new Paragraph("Amount Paid: " + booking.getTotalPrice()));
//
//        Table table = new Table(4);
//        table.addCell(new Cell().add(new Paragraph("First Name")));
//        table.addCell(new Cell().add(new Paragraph("Last Name")));
//        table.addCell(new Cell().add(new Paragraph("Email")));
//        table.addCell(new Cell().add(new Paragraph("Phone")));
//
//        for (Passenger passenger : booking.getPassengers()) {
//            table.addCell(new Cell().add(new Paragraph(passenger.getFirstName())));
//            table.addCell(new Cell().add(new Paragraph(passenger.getLastName())));
//            table.addCell(new Cell().add(new Paragraph(passenger.getEmail())));
//            table.addCell(new Cell().add(new Paragraph(passenger.getPhone())));
//        }
//
//        document.add(table);
//        document.close();
//
//        return byteArrayOutputStream.toByteArray();
//    }
}

