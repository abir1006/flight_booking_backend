package flight_booking.repositories.genericrepository;

import flight_booking.domain.Report;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends GenericRepository<Report, Long> {
}