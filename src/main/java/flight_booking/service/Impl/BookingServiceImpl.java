package flight_booking.service.Impl;

import flight_booking.domain.Booking;
import flight_booking.dto.BookingDto;
import flight_booking.repositories.BookingRepository;
import flight_booking.service.BookingService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookingServiceImpl extends GenericServiceImpl<Booking, Long, BookingDto> implements BookingService {
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final BookingRepository bookingRepository;
   // private final PaymentService paymentService;

    @Autowired
    public BookingServiceImpl(BookingRepository repository, ModelMapper modelMapper, BookingRepository bookingRepository) {
        super(repository, modelMapper, Booking.class, BookingDto.class);
        this.modelMapper = modelMapper;
        this.bookingRepository = bookingRepository;
    }

    @Override
    @Transactional
    public BookingDto bookFlight(BookingDto bookingDto) {
        bookingDto.setBookingDate(LocalDate.now());
            bookingDto.setStatus("BOOKED WITHOUT PAYMENT");
            Booking booking = modelMapper.map(bookingDto, Booking.class);
            booking = bookingRepository.save(booking);
            return modelMapper.map(booking, BookingDto.class);
    }

    @Override
    @Transactional
    public BookingDto cancelBooking(Long bookingId) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            booking.setStatus("CANCELLED");
            booking = bookingRepository.save(booking);
            return modelMapper.map(booking, BookingDto.class);
        }
        return null;
        // or throw an exception for not found
    }
    @Override
    public String generateTicket(Long bookingId) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            // Generate ticket logic here (e.g., format a ticket string or generate a PDF)
            return "TICKET-" + booking.getId() + "-" + booking.getBookingDate().atTime(12, 0);
        }
        return null; // or throw an exception for not found
    }
    // Additional Booking-specific business implemented here
}

