package flight_booking.service.Impl;

import flight_booking.domain.Airport;
import flight_booking.repositories.AirportRepository;
import flight_booking.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AirportServiceImpl extends GenericServiceImpl<Airport,Long> implements AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository) {
        super(airportRepository);
        this.airportRepository = airportRepository;
    }

}
