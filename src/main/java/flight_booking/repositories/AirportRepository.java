package flight_booking.repositories;

import flight_booking.domain.Airport;
import flight_booking.repositories.genericrepository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends GenericRepository<Airport, Long> {
}
