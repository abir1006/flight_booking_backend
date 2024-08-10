package flight_booking.repositories;

import flight_booking.domain.Airline;
import flight_booking.repositories.genericrepository.GenericRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends GenericRepository<Airline, Long> {
}
