package flight_booking.service.Impl;

import flight_booking.domain.Airline;
import flight_booking.dto.AirlineDto;
import flight_booking.repositories.AirlineRepository;
import flight_booking.service.AirlineService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AirlineServiceImpl extends GenericServiceImpl<Airline,Long,AirlineDto> implements AirlineService {
    public AirlineServiceImpl(AirlineRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, Airline.class, AirlineDto.class);
    }
}
