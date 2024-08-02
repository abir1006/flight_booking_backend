package flight_booking.service;

import flight_booking.dto.FlightDto;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {

    FlightDto createFlight(FlightDto flightDto);

    List<FlightDto> getAllFlights();

    FlightDto getFlightById(Long id);

    FlightDto updateFlight(Long id, FlightDto flightDto);

    void deleteFlight(Long id);

    List<FlightDto> searchByAirport(Long airportId);

    List<FlightDto> searchFlightsByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    List<FlightDto> searchByAvailableSeats(int availableSeats);
//   //There should be Airplane Entity model
//    List<FlightDto> searchByAvailablePlanes(String planeModel);

    List<FlightDto> searchPublicEndpoint();
}
