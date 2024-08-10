package flight_booking.service.Impl;

import flight_booking.domain.Airline;
import flight_booking.dto.AirlineDto;
import flight_booking.dto.AirlineVanillaDto;
import flight_booking.repositories.AirlineRepository;
import flight_booking.service.AirlineVanillaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AirlineVanillaServiceImpl extends GenericServiceImpl<Airline,Long, AirlineVanillaDto> implements AirlineVanillaService {
    public AirlineVanillaServiceImpl(AirlineRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, Airline.class, AirlineVanillaDto.class);
    }
}
