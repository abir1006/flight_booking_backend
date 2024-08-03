package flight_booking.repositories;

import flight_booking.domain.Payment;
import flight_booking.repositories.genericrepository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends GenericRepository<Payment, Long> {
}
