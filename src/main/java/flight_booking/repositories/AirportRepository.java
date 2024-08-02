package flight_booking.repositories;

import flight_booking.domain.Airport;
import flight_booking.repositories.genericrepository.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends GenericRepository<Airport, Long> {

    Page<Airport> findAll(Pageable pageable);
}
