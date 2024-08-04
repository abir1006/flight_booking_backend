package flight_booking.repositories;

import flight_booking.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE f.departureAirport.id = :airportId OR f.arrivalAirport.id = :airportId")
    List<Flight> findByAirport(Long airportId);

    @Query("SELECT f FROM Flight f WHERE f.flightSchedule.departureDate >= :startDate AND f.flightSchedule.departureDate <= :endDate")
    List<Flight> findByFlightSchedule_DepartureDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Flight> findByAvailableSeatsGreaterThanEqual(int availableSeats);

    //There should be Airplane Entity
//    List<Flight> findByPlaneModel(String planeModel);
}