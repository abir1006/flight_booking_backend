package flight_booking.service.Impl;

import flight_booking.domain.Booking;
import flight_booking.domain.Passenger;
import flight_booking.dto.BookingDto;
import flight_booking.repositories.BookingRepository;
import flight_booking.service.BookingService;
import flight_booking.service.PaymentService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookingServiceImpl extends GenericServiceImpl<Booking, Long, BookingDto> implements BookingService {
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final BookingRepository bookingRepository;
    private final PaymentService paymentService;

    @Autowired
    public BookingServiceImpl(BookingRepository repository, ModelMapper modelMapper, BookingRepository bookingRepository, PaymentService paymentService) {
        super(repository, modelMapper, Booking.class, BookingDto.class);
        this.modelMapper = modelMapper;
        this.bookingRepository = bookingRepository;
        this.paymentService = paymentService;
    }

    @Override
    @Transactional
    public BookingDto bookFlight(BookingDto bookingDto) {
        bookingDto.setBookingDate(LocalDate.now());
        bookingDto.setStatus("BOOKED WITHOUT PAYMENT");
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        final Booking finalBooking = booking;
        booking.setPassengers(
                bookingDto.getPassengers().stream()
                        .map(passengerDto -> {
                            Passenger passenger = modelMapper.map(passengerDto, Passenger.class);
                            passenger.setBooking(finalBooking);
                            return passenger;
                        })
                        .toList()
        );
        booking = bookingRepository.save(booking);
        return modelMapper.map(booking, BookingDto.class);
    }

    @Override
    @Transactional
    public BookingDto cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));
        booking.setStatus("CANCELLED");
        booking = bookingRepository.save(booking);
        return modelMapper.map(booking, BookingDto.class);
    }

    @Override
    public String generateTicket(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));

        StringBuilder ticketBuilder = new StringBuilder();
        ticketBuilder.append("Flight Booking Ticket\n")
                .append("Booking ID: ").append(booking.getId()).append("\n")
                .append("Booking Date: ").append(booking.getBookingDate().toString()).append("\n")
                .append("Status: ").append(booking.getStatus()).append("\n")
                .append("Trip Type: ").append(booking.getTripType()).append("\n")
                .append("Amount Paid: ").append(booking.getFlight().getTicketPrice()).append("\n")
                .append("Passengers:\n");

        for (Passenger passenger : booking.getPassengers()) {
            ticketBuilder.append("Name: ").append(passenger.getFirstName()).append(" ").append(passenger.getLastName()).append("\n")
                    .append("Email: ").append(passenger.getEmail()).append("\n")
                    .append("Phone: ").append(passenger.getPhone()).append("\n")
                    .append("Address: ").append(passenger.getAddress()).append("\n")
                    .append("-----\n");
        }

        return ticketBuilder.toString();
    }

    @Override
    @Transactional
    public BookingDto confirmBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));
        boolean paymentConfirmed = paymentService.confirmBooking(bookingId);
        if (!paymentConfirmed) {
            throw new RuntimeException("Payment confirmation failed for booking ID: " + bookingId);
        }
        booking.setStatus("CONFIRMED");

        String ticket = generateTicket(bookingId);

        booking = bookingRepository.save(booking);
        BookingDto bookingDto = modelMapper.map(booking, BookingDto.class);
        bookingDto.setTicket(ticket);

        return bookingDto;

        // Additional Booking-specific business implemented here
    }
}








