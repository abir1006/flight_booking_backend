package flight_booking.service;

import flight_booking.dto.FlightDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    List<List<FlightDto>> searchFlights(Long departureAirportId, Long arrivalAirportId, LocalDate startDate, LocalDate endDate, Integer travellers);
//   //There should be Airplane Entity model
//    List<FlightDto> searchByAvailablePlanes(String planeModel);

    List<FlightDto> searchPublicEndpoint();
}
