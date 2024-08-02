package flight_booking.service.Impl;

import flight_booking.domain.Passenger;
import flight_booking.dto.BookingDto;
import flight_booking.dto.PassengerDto;
import flight_booking.repositories.genericrepository.PassengerRepository;
import flight_booking.service.PassengerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl extends GenericServiceImpl<Passenger, Long, PassengerDto> implements PassengerService {

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, ModelMapper modelMapper) {
        super(passengerRepository, modelMapper, Passenger.class, PassengerDto.class);
    }
}
