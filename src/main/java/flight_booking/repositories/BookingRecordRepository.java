package flight_booking.repositories;

import flight_booking.domain.BookingRecord;
import flight_booking.repositories.genericrepository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRecordRepository extends GenericRepository<BookingRecord, Long> {
}