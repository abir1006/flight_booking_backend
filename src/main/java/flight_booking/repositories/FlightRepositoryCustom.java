package flight_booking.repositories;

import flight_booking.domain.Flight;
import flight_booking.dto.FlightDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface FlightRepositoryCustom {
    List<Flight> searchFlights(Long departureAirportId, Long arrivalAirportId, LocalDate date, Integer travellers, boolean isOutbound);
}