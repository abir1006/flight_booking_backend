package flight_booking.service.Impl;

import flight_booking.domain.Flight;
import flight_booking.dto.FlightDto;
import flight_booking.repositories.FlightRepository;
import flight_booking.service.FlightService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class FlightServiceImpl implements FlightService {

    private FlightRepository flightRepository;
    private ModelMapper modelMapper;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, ModelMapper modelMapper) {
        this.flightRepository = flightRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FlightDto createFlight(FlightDto flightDto) {
        Flight flight = modelMapper.map(flightDto, Flight.class);
        flight = flightRepository.save(flight);
        return modelMapper.map(flight, FlightDto.class);
    }

    @Override
    public List<FlightDto> getAllFlights() {
        return flightRepository.findAll().stream()
                .map(flight -> modelMapper.map(flight, FlightDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FlightDto getFlightById(Long id) {
        Flight flight = flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
        return modelMapper.map(flight, FlightDto.class);
    }

    @Override
    public FlightDto updateFlight(Long id, FlightDto flightDto) {
        Flight flight = flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
        modelMapper.map(flightDto, flight);
        flight = flightRepository.save(flight);
        return modelMapper.map(flight, FlightDto.class);
    }

    @Override
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
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
