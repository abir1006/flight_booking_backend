package flight_booking.service;


import flight_booking.domain.Airport;
import flight_booking.dto.AirportDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AirportService extends GenericService<Long,AirportDto> {

    public Page<AirportDto> getPaginatedAirports(Pageable pageable);
}
