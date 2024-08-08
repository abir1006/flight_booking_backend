package flight_booking.repositories;

import flight_booking.domain.Passenger;
import flight_booking.repositories.genericrepository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends GenericRepository<Passenger, Long> {
    Passenger findByEmail(String email);
}