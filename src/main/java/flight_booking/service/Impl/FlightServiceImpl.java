package flight_booking.service.Impl;


import flight_booking.domain.Flight;
import flight_booking.dto.FlightDto;
import flight_booking.repositories.FlightRepository;
import flight_booking.repositories.FlightRepositoryCustom;
import flight_booking.repositories.customImpl.FlightRepositoryCustomImpl;
import flight_booking.service.FlightService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service

public class FlightServiceImpl extends GenericServiceImpl<Flight,Long,FlightDto> implements FlightService {

    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;
    private final FlightRepositoryCustomImpl flightRepositoryCustomImpl;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, ModelMapper modelMapper, FlightRepositoryCustomImpl flightRepositoryCustomImpl) {
        super(flightRepository,modelMapper, Flight.class, FlightDto.class);
        this.flightRepository = flightRepository;
        this.modelMapper = modelMapper;
        this.flightRepositoryCustomImpl = flightRepositoryCustomImpl;
    }


    @Override
    public FlightDto update(Long id, FlightDto flightDto) {
        Flight flight = flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
        flight.setFlightNumber(flightDto.getFlightNumber());
        flight.setAvailableSeats(flightDto.getAvailableSeats());
        flight.setArrivalAirport(flightDto.getArrivalAirport());
        flight.setFlightSchedule(flightDto.getFlightSchedule());
        flight.setDepartureAirport(flightDto.getDepartureAirport());
        flightRepository.save(flight);
        return modelMapper.map(flight, FlightDto.class);
    }

    @Override
    public List<FlightDto> searchByAirport(Long airportId) {
        return flightRepository.findByAirport(airportId).stream()
                .map(flight -> modelMapper.map(flight, FlightDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDto> searchFlightsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return flightRepository.findByFlightSchedule_DepartureDateTimeBetween(startDate, endDate).stream()
                .map(flight -> modelMapper.map(flight, FlightDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDto> searchByAvailableSeats(int availableSeats) {
        return flightRepository.findByAvailableSeatsGreaterThanEqual(availableSeats).stream()
                .map(flight -> modelMapper.map(flight, FlightDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDto> searchByTicketPrice(double ticketPrice) {
        return flightRepository.searchByTicketPrice(ticketPrice).stream()
                .map(flight -> modelMapper.map(flight, FlightDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<FlightDto> searchByAirline(Long id) {
        return flightRepository.searchByAirline(id).stream()
                .map(flight -> modelMapper.map(flight, FlightDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<List<FlightDto>> searchFlights(Long departureAirportId, Long arrivalAirportId, LocalDate startDate, LocalDate endDate, Integer travellers) {
        List<FlightDto> outboundFlights = flightRepositoryCustomImpl.searchFlights(departureAirportId, arrivalAirportId, startDate, travellers, true)
                .stream()
                .map(flight -> {
                    FlightDto flightDto = modelMapper.map(flight, FlightDto.class);
                    flightDto.setAirlineName(flight.getAirline().getAirlineName());
                    flightDto.setAirlineLogo(flight.getAirline().getAirlineLogo());
                    return flightDto;
                })
                .collect(Collectors.toList());

        List<FlightDto> returnFlights = flightRepositoryCustomImpl.searchFlights(departureAirportId, arrivalAirportId, endDate, travellers, false)
                .stream()
                .map(flight -> {
                    FlightDto flightDto = modelMapper.map(flight, FlightDto.class);
                    flightDto.setAirlineName(flight.getAirline().getAirlineName());
                    flightDto.setAirlineLogo(flight.getAirline().getAirlineLogo());
                    return flightDto;
                })
                .collect(Collectors.toList());

        List<List<FlightDto>> result = new ArrayList<>();
        result.add(outboundFlights);
        result.add(returnFlights);
        return result;
    }


    //There should be Airplane Entity model
//    @Override
//    public List<FlightDto> searchByAvailablePlanes(String planeModel) {
//        return flightRepository.findByPlaneModel(planeModel).stream()
//                .map(flight -> modelMapper.map(flight, FlightDto.class))
//                .collect(Collectors.toList());
//    }

    @Override
    public List<FlightDto> searchPublicEndpoint() {
        return flightRepository.findAll().stream()
                .map(flight -> modelMapper.map(flight, FlightDto.class))
                .collect(Collectors.toList());
    }
}
