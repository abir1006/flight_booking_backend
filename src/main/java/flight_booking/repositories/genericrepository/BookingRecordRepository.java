package flight_booking.repositories.genericrepository;

import flight_booking.domain.BookingRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRecordRepository extends GenericRepository<BookingRecord, Long> {
}