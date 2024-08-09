package flight_booking.repositories;

import flight_booking.domain.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepositoryCustom {
    List<List<Flight>> searchFlights(Long departureAirportId, Long arrivalAirportId, LocalDate startDate, LocalDate endDate, Integer travellers);
}