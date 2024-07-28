package flight_booking.service.Impl;

import flight_booking.config.securityConfig.UserRepository;
import flight_booking.domain.Airport;
import flight_booking.dto.AirportDto;
import flight_booking.repositories.AirportRepository;
import flight_booking.service.AirportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl extends GenericServiceImpl<Airport, Long, AirportDto> implements AirportService {

    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository, ModelMapper modelMapper) {
        super(airportRepository, modelMapper, Airport.class, AirportDto.class);
    }
}
