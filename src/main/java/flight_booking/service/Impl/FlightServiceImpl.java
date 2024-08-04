package flight_booking.service.Impl;


import flight_booking.domain.Flight;
import flight_booking.dto.FlightDto;
import flight_booking.repositories.FlightRepository;
import flight_booking.service.FlightService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class FlightServiceImpl extends GenericServiceImpl<Flight,Long,FlightDto> implements FlightService {

    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, ModelMapper modelMapper) {
        super(flightRepository,modelMapper, Flight.class, FlightDto.class);
        this.flightRepository = flightRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public FlightDto update(Long id, FlightDto flightDto) {
        Flight flight = flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
        flight.setFlightLogo(flightDto.getFlightLogo());
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
    public List<FlightDto> searchFlights(Long departureAirportId, Long arrivalAirportId, LocalDate startDate, LocalDate endDate, Integer travellers) {
        List<Flight> flights = flightRepository.searchFlights(departureAirportId, arrivalAirportId, startDate, endDate, travellers);
        return flights.stream()
                .map(flight -> modelMapper.map(flight, FlightDto.class))
                .collect(Collectors.toList());
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
