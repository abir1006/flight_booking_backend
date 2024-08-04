package flight_booking.repositories;

import flight_booking.domain.Report;
import flight_booking.repositories.genericrepository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends GenericRepository<Report, Long> {
}