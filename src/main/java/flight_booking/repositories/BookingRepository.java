package flight_booking.repositories;


import flight_booking.domain.Booking;
import flight_booking.repositories.genericrepository.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends GenericRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b JOIN b.passengers p WHERE p.email = :email")
    Page<Booking> findBookingsByPassengerEmail(@Param("email") String email, Pageable pageable);
}


