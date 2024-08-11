package flight_booking.repositories;

import flight_booking.domain.Flight;
import flight_booking.repositories.genericrepository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends GenericRepository<Flight, Long>, FlightRepositoryCustom {

    @Query("SELECT f FROM Flight f WHERE f.departureAirport.id = :airportId OR f.arrivalAirport.id = :airportId")
    List<Flight> findByAirport(Long airportId);

    @Query("SELECT f FROM Flight f WHERE f.flightSchedule.departureDate >= :startDate AND f.flightSchedule.departureDate <= :endDate")
    List<Flight> findByFlightSchedule_DepartureDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Flight> findByAvailableSeatsGreaterThanEqual(int availableSeats);
}
