package flight_booking.repositories;


import flight_booking.domain.Booking;
import flight_booking.repositories.genericrepository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends GenericRepository<Booking, Long> {
}

