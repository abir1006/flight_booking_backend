package flight_booking.service;

import flight_booking.domain.Flight;
import flight_booking.dto.FlightDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface FlightService extends GenericService<Long, FlightDto> {

//    FlightDto createFlight(FlightDto flightDto);
//
//    List<FlightDto> getAllFlights();
//
//    FlightDto getFlightById(Long id);
//
//    FlightDto updateFlight(Long id, FlightDto flightDto);
//
//    void deleteFlight(Long id);
    /***/

    List<FlightDto> searchByAirport(Long airportId);

    List<FlightDto> searchFlightsByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    List<FlightDto> searchByAvailableSeats(int availableSeats);

    List<List<FlightDto>> searchFlights(Long departureAirportId, Long arrivalAirportId, LocalDate startDate, LocalDate endDate, Integer travellers, List<Long> airlines, Double ticketPrice);
//   //There should be Airplane Entity model
//    List<FlightDto> searchByAvailablePlanes(String planeModel);

    List<FlightDto> searchPublicEndpoint();
}
