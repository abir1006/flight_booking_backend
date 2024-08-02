package flight_booking.repositories.genericrepository;

import flight_booking.domain.Passenger;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends GenericRepository<Passenger, Long> {
}