package flight_booking.repositories;

import flight_booking.domain.Airport;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends GenericRepository<Airport,Long> {
}
