package flight_booking.service.Impl;

import flight_booking.domain.Booking;
import flight_booking.domain.Flight;
import flight_booking.domain.Passenger;
import flight_booking.dto.BookingDto;
import flight_booking.events.FlightBookingEvent;
import flight_booking.repositories.BookingRepository;
import flight_booking.repositories.FlightRepository;
import flight_booking.service.BookingService;
//import flight_booking.service.NotificationService;
import flight_booking.service.PaymentService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class BookingServiceImpl extends GenericServiceImpl<Booking, Long, BookingDto> implements BookingService {
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final BookingRepository bookingRepository;
    @Autowired
    private final PaymentService paymentService;
    @Autowired
    private final FlightRepository flightRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    //private NotificationService notificationService;

    @Autowired
    public BookingServiceImpl(BookingRepository repository, ModelMapper modelMapper, BookingRepository bookingRepository, PaymentService paymentService, FlightRepository flightRepository) {
        super(repository, modelMapper, Booking.class, BookingDto.class);
        this.modelMapper = modelMapper;
        this.bookingRepository = bookingRepository;
        this.paymentService = paymentService;
        this.flightRepository = flightRepository;
    }

    @Override
    @Transactional
    public BookingDto bookFlight(BookingDto bookingDto) {
        bookingDto.setBookingDate(LocalDate.now());
        bookingDto.setStatus("PENDING");

        Flight flight = flightRepository.findById(bookingDto.getFlightId())
                .orElseThrow(() -> new RuntimeException("Flight not found with ID: " + bookingDto.getFlightId()));
        int passengersCount = bookingDto.getPassengers().size();
        if (flight.getAvailableSeats() < passengersCount) {
            throw new RuntimeException("Not enough available seats for flight ID: " + bookingDto.getFlightId());
        }
        flight.setAvailableSeats(flight.getAvailableSeats() - passengersCount);
        flightRepository.save(flight);
        bookingDto.setAirlineName(flight.getAirline().getAirlineName());
        bookingDto.setFlightNumber(flight.getFlightNumber());
        bookingDto.setDepartureAirportName(flight.getDepartureAirport().getName());
        bookingDto.setDepartureAirportCity(flight.getDepartureAirport().getCity());
        bookingDto.setDepartureAirportCountry(flight.getDepartureAirport().getCountry());
        bookingDto.setCodeDepartureAirport(flight.getDepartureAirport().getCode());
        bookingDto.setDepartureDate(flight.getFlightSchedule().getDepartureDate());
        bookingDto.setDepartureTime(flight.getFlightSchedule().getDepartureTime());

        bookingDto.setArrivalAirportName(flight.getArrivalAirport().getName());
        bookingDto.setArrivalAirportCity(flight.getArrivalAirport().getCity());
        bookingDto.setArrivalAirportCountry(flight.getArrivalAirport().getCountry());
        bookingDto.setCodeArrivalAirport(flight.getArrivalAirport().getCode());
        bookingDto.setArrivalDate(flight.getFlightSchedule().getArrivalDate());
        bookingDto.setArrivalTime(flight.getFlightSchedule().getArrivalTime());

        if ("ROUND_TRIP".equalsIgnoreCase(bookingDto.getTripType())) {
            Flight returnFlight = flightRepository.findById(bookingDto.getReturnFlightId())
                    .orElseThrow(() -> new RuntimeException("Return flight not found with ID: " + bookingDto.getReturnFlightId()));
            int returnPassengersCount = bookingDto.getPassengers().size();
            if (returnFlight.getAvailableSeats() < returnPassengersCount) {
                throw new RuntimeException("Not enough available seats for return flight ID: " + bookingDto.getReturnFlightId());
            }
            returnFlight.setAvailableSeats(returnFlight.getAvailableSeats() - returnPassengersCount);
            flightRepository.save(returnFlight);
            bookingDto.setAirlineName(flight.getAirline().getAirlineName());
            bookingDto.setFlightNumber(flight.getFlightNumber());
            bookingDto.setDepartureAirportName(flight.getDepartureAirport().getName());
            bookingDto.setDepartureAirportCity(flight.getDepartureAirport().getCity());
            bookingDto.setDepartureAirportCountry(flight.getDepartureAirport().getCountry());
            bookingDto.setCodeDepartureAirport(flight.getDepartureAirport().getCode());
            bookingDto.setReturnDepartureDate(returnFlight.getFlightSchedule().getDepartureDate());
            bookingDto.setReturnDepartureTime(returnFlight.getFlightSchedule().getDepartureTime());
            bookingDto.setArrivalAirportName(flight.getArrivalAirport().getName());
            bookingDto.setArrivalAirportCity(flight.getArrivalAirport().getCity());
            bookingDto.setArrivalAirportCountry(flight.getArrivalAirport().getCountry());
            bookingDto.setCodeArrivalAirport(flight.getArrivalAirport().getCode());

            bookingDto.setReturnArrivalDate(returnFlight.getFlightSchedule().getArrivalDate());
            bookingDto.setReturnArrivalTime(returnFlight.getFlightSchedule().getArrivalTime());

            bookingDto.setTotalPrice(bookingDto.getTotalPrice());
        }

        Booking booking = modelMapper.map(bookingDto, Booking.class);
        Booking finalBooking = booking;
        booking.setPassengers(
                bookingDto.getPassengers().stream()
                        .map(passengerDto -> {
                            Passenger passenger = modelMapper.map(passengerDto, Passenger.class);
                            passenger.setBooking(finalBooking);
                            return passenger;
                        })
                        .toList()
        );
        booking.setTotalPrice(bookingDto.getTotalPrice());
        booking = bookingRepository.save(booking);

        // Map the schedule information to the BookingDto
        BookingDto savedBookingDto = modelMapper.map(booking, BookingDto.class);
        savedBookingDto.setAirlineName(flight.getAirline().getAirlineName());
        savedBookingDto.setFlightNumber(flight.getFlightNumber());
        savedBookingDto.setDepartureAirportName(flight.getDepartureAirport().getName());
        savedBookingDto.setDepartureAirportCity(flight.getDepartureAirport().getCity());
        savedBookingDto.setDepartureAirportCountry(flight.getDepartureAirport().getCountry());
        savedBookingDto.setCodeDepartureAirport(flight.getDepartureAirport().getCode());
        savedBookingDto.setArrivalAirportName(flight.getArrivalAirport().getName());
        savedBookingDto.setArrivalAirportCity(flight.getArrivalAirport().getCity());
        savedBookingDto.setArrivalAirportCountry(flight.getArrivalAirport().getCountry());
        savedBookingDto.setCodeArrivalAirport(flight.getArrivalAirport().getCode());

        savedBookingDto.setDepartureDate(flight.getFlightSchedule().getDepartureDate());
        savedBookingDto.setDepartureTime(flight.getFlightSchedule().getDepartureTime());
        savedBookingDto.setArrivalDate(flight.getFlightSchedule().getArrivalDate());
        savedBookingDto.setArrivalTime(flight.getFlightSchedule().getArrivalTime());

        if ("ROUND_TRIP".equalsIgnoreCase(bookingDto.getTripType())) {
            Flight returnFlight = flightRepository.findById(bookingDto.getReturnFlightId())
                    .orElseThrow(() -> new RuntimeException("Return flight not found with ID: " + bookingDto.getReturnFlightId()));
            savedBookingDto.setAirlineName(returnFlight.getAirline().getAirlineName());
            savedBookingDto.setReturnFlightNumber(returnFlight.getFlightNumber());
            savedBookingDto.setReturnDepartureAirportName(returnFlight.getDepartureAirport().getName());
            savedBookingDto.setReturnDepartureAirportCity(returnFlight.getDepartureAirport().getCity());
            savedBookingDto.setReturnDepartureAirportCountry(returnFlight.getDepartureAirport().getCountry());
            savedBookingDto.setReturnCodeDepartureAirport(returnFlight.getDepartureAirport().getCode());
            savedBookingDto.setReturnArrivalAirportName(returnFlight.getArrivalAirport().getName());
            savedBookingDto.setReturnArrivalAirportCity(returnFlight.getArrivalAirport().getCity());
            savedBookingDto.setReturnArrivalAirportCountry(returnFlight.getArrivalAirport().getCountry());
            savedBookingDto.setReturnCodeArrivalAirport(returnFlight.getArrivalAirport().getCode());

            savedBookingDto.setReturnDepartureDate(returnFlight.getFlightSchedule().getDepartureDate());
            savedBookingDto.setReturnDepartureTime(returnFlight.getFlightSchedule().getDepartureTime());
            savedBookingDto.setReturnArrivalDate(returnFlight.getFlightSchedule().getArrivalDate());
            savedBookingDto.setReturnArrivalTime(returnFlight.getFlightSchedule().getArrivalTime());
        }

        return savedBookingDto;
    }

    @Override
    @Transactional
    public BookingDto cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));
        booking.setStatus("CANCELLED");

        Flight flight = booking.getFlight();
        flight.setAvailableSeats(flight.getAvailableSeats() + booking.getPassengers().size());
        flightRepository.save(flight);

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
                .append("Trip Type: ").append(booking.getTripType()).append("\n")
                .append("Amount Paid: ").append(booking.getTotalPrice()).append("\n")
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

//        byte[] ticketPdf = generateTicketPdf(booking);
//
//        try {
//            notificationService.sendEmailWithAttachment(
//                    booking.getPassengers().get(0).getEmail(),
//                    "Flight Ticket",
//                    "Please find attached your flight ticket.",
//                    ticketPdf
//            );
//        } catch (MessagingException e) {
//            throw new RuntimeException("Failed to send email with ticket PDF for booking ID: " + bookingId, e);
//        }

        booking = bookingRepository.save(booking);
        BookingDto bookingDto = modelMapper.map(booking, BookingDto.class);
        eventPublisher.publishEvent(new FlightBookingEvent(this, booking));
        bookingDto.setTicket(ticket);

        return bookingDto;
    }

    @Override
    @Transactional
    public BookingDto updateBooking(Long bookingId, BookingDto bookingDto) {
        Booking existingBooking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));

        Flight existingFlight = existingBooking.getFlight();
        int originalPassengerCount = existingBooking.getPassengers().size();

        // Restore the available seats for the original flight
        existingFlight.setAvailableSeats(existingFlight.getAvailableSeats() + originalPassengerCount);
        flightRepository.save(existingFlight);

        // Retrieve and update the new flight
        Flight newFlight = flightRepository.findById(bookingDto.getFlightId())
                .orElseThrow(() -> new RuntimeException("Flight not found with ID: " + bookingDto.getFlightId()));
        int newPassengerCount = bookingDto.getPassengers().size();

        if (newFlight.getAvailableSeats() < newPassengerCount) {
            throw new RuntimeException("Not enough available seats for flight ID: " + bookingDto.getFlightId());
        }

        newFlight.setAvailableSeats(newFlight.getAvailableSeats() - newPassengerCount);
        flightRepository.save(newFlight);

        existingBooking.setFlight(newFlight);
        existingBooking.setTripType(bookingDto.getTripType());
        existingBooking.setBookingDate(LocalDate.now());
        existingBooking.setTotalPrice(bookingDto.getTotalPrice());

        bookingDto.setAirlineName(newFlight.getAirline().getAirlineName());
        bookingDto.setFlightNumber(newFlight.getFlightNumber());
        bookingDto.setDepartureAirportName(newFlight.getDepartureAirport().getName());
        bookingDto.setDepartureAirportCity(newFlight.getDepartureAirport().getCity());
        bookingDto.setDepartureAirportCountry(newFlight.getDepartureAirport().getCountry());
        bookingDto.setCodeDepartureAirport(newFlight.getDepartureAirport().getCode());
        bookingDto.setArrivalAirportName(newFlight.getArrivalAirport().getName());
        bookingDto.setArrivalAirportCity(newFlight.getArrivalAirport().getCity());
        bookingDto.setArrivalAirportCountry(newFlight.getArrivalAirport().getCountry());
        bookingDto.setCodeArrivalAirport(newFlight.getArrivalAirport().getCode());
        bookingDto.setDepartureDate(newFlight.getFlightSchedule().getDepartureDate());
        bookingDto.setDepartureTime(newFlight.getFlightSchedule().getDepartureTime());
        bookingDto.setArrivalDate(newFlight.getFlightSchedule().getArrivalDate());
        bookingDto.setArrivalTime(newFlight.getFlightSchedule().getArrivalTime());

        if ("ROUND_TRIP".equalsIgnoreCase(bookingDto.getTripType())) {
            Flight returnFlight = flightRepository.findById(bookingDto.getReturnFlightId())
                    .orElseThrow(() -> new RuntimeException("Return flight not found with ID: " + bookingDto.getReturnFlightId()));

            if (returnFlight.getAvailableSeats() < newPassengerCount) {
                throw new RuntimeException("Not enough available seats for return flight ID: " + bookingDto.getReturnFlightId());
            }

            returnFlight.setAvailableSeats(returnFlight.getAvailableSeats() - newPassengerCount);
            flightRepository.save(returnFlight);
            bookingDto.setAirlineName(returnFlight.getAirline().getAirlineName());
            bookingDto.setReturnFlightNumber(returnFlight.getFlightNumber());
            bookingDto.setReturnDepartureAirportName(returnFlight.getDepartureAirport().getName());
            bookingDto.setReturnDepartureAirportCity(returnFlight.getDepartureAirport().getCity());
            bookingDto.setReturnDepartureAirportCountry(returnFlight.getDepartureAirport().getCountry());
            bookingDto.setReturnCodeDepartureAirport(returnFlight.getDepartureAirport().getCode());
            bookingDto.setReturnArrivalAirportName(returnFlight.getArrivalAirport().getName());
            bookingDto.setReturnArrivalAirportCity(returnFlight.getArrivalAirport().getCity());
            bookingDto.setReturnArrivalAirportCountry(returnFlight.getArrivalAirport().getCountry());
            bookingDto.setReturnCodeArrivalAirport(returnFlight.getArrivalAirport().getCode());

            bookingDto.setReturnDepartureDate(returnFlight.getFlightSchedule().getDepartureDate());
            bookingDto.setReturnDepartureTime(returnFlight.getFlightSchedule().getDepartureTime());
            bookingDto.setReturnArrivalDate(returnFlight.getFlightSchedule().getArrivalDate());
            bookingDto.setReturnArrivalTime(returnFlight.getFlightSchedule().getArrivalTime());
        }

        List<Passenger> updatedPassengers = bookingDto.getPassengers().stream()
                .map(passengerDto -> {
                    Passenger passenger = modelMapper.map(passengerDto, Passenger.class);
                    passenger.setBooking(existingBooking);
                    return passenger;
                }).toList();
        existingBooking.setPassengers(updatedPassengers);

        Booking updatedBooking = bookingRepository.save(existingBooking);
        return modelMapper.map(updatedBooking, BookingDto.class);
    }

//    @Override
//    @Transactional
//    public Page<BookingDto> getBookingsByPassengerEmail(String email, Pageable pageable) {
//        Page<Booking> bookings = bookingRepository.findBookingsByPassengerEmail(email, pageable);
//        return bookings.map(booking -> modelMapper.map(booking, BookingDto.class));
//    }
    @Override
    @Transactional
    public Page<BookingDto> getBookingsByPassengerEmail(String email, Pageable pageable) {
        Page<Booking> bookings = bookingRepository.findBookingsByPassengerEmail(email, pageable);

        return bookings.map(booking -> {
            BookingDto bookingDto = modelMapper.map(booking, BookingDto.class);
            if (booking.getFlight() != null) {
                Flight flight = booking.getFlight();
                bookingDto.setAirlineName(flight.getAirline().getAirlineName());
                bookingDto.setFlightNumber(flight.getFlightNumber());
                bookingDto.setDepartureAirportName(flight.getDepartureAirport().getName());
                bookingDto.setDepartureAirportCity(flight.getDepartureAirport().getCity());
                bookingDto.setDepartureAirportCountry(flight.getDepartureAirport().getCountry());
                bookingDto.setCodeDepartureAirport(flight.getDepartureAirport().getCode());
                bookingDto.setArrivalAirportName(flight.getArrivalAirport().getName());
                bookingDto.setArrivalAirportCity(flight.getArrivalAirport().getCity());
                bookingDto.setArrivalAirportCountry(flight.getArrivalAirport().getCountry());
                bookingDto.setCodeArrivalAirport(flight.getArrivalAirport().getCode());
                bookingDto.setDepartureDate(flight.getFlightSchedule().getDepartureDate());
                bookingDto.setDepartureTime(flight.getFlightSchedule().getDepartureTime());
                bookingDto.setArrivalDate(flight.getFlightSchedule().getArrivalDate());
                bookingDto.setArrivalTime(flight.getFlightSchedule().getArrivalTime());
            }

            if ("ROUND_TRIP".equalsIgnoreCase(bookingDto.getTripType())) {
                Flight returnFlight = flightRepository.findById(bookingDto.getReturnFlightId())
                        .orElseThrow(() -> new RuntimeException("Return flight not found with ID: " + bookingDto.getReturnFlightId()));

                bookingDto.setReturnAirlineName(returnFlight.getAirline().getAirlineName());
                bookingDto.setReturnFlightNumber(returnFlight.getFlightNumber());
                bookingDto.setReturnDepartureAirportName(returnFlight.getDepartureAirport().getName());
                bookingDto.setReturnDepartureAirportCity(returnFlight.getDepartureAirport().getCity());
                bookingDto.setReturnDepartureAirportCountry(returnFlight.getDepartureAirport().getCountry());
                bookingDto.setReturnCodeDepartureAirport(returnFlight.getDepartureAirport().getCode());
                bookingDto.setReturnArrivalAirportName(returnFlight.getArrivalAirport().getName());
                bookingDto.setReturnArrivalAirportCity(returnFlight.getArrivalAirport().getCity());
                bookingDto.setReturnArrivalAirportCountry(returnFlight.getArrivalAirport().getCountry());
                bookingDto.setReturnCodeArrivalAirport(returnFlight.getArrivalAirport().getCode());
                bookingDto.setReturnDepartureDate(returnFlight.getFlightSchedule().getDepartureDate());
                bookingDto.setReturnDepartureTime(returnFlight.getFlightSchedule().getDepartureTime());
                bookingDto.setReturnArrivalDate(returnFlight.getFlightSchedule().getArrivalDate());
                bookingDto.setReturnArrivalTime(returnFlight.getFlightSchedule().getArrivalTime());
            }

            return bookingDto;
        });
    }


}
