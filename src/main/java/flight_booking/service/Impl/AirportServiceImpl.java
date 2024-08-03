package flight_booking.service.Impl;


import flight_booking.domain.Airport;
import flight_booking.dto.AirportDto;
import flight_booking.repositories.AirportRepository;
import flight_booking.service.AirportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportServiceImpl extends GenericServiceImpl<Airport, Long, AirportDto> implements AirportService {

    private final AirportRepository airportRepository;
    private final ReportServiceImpl reportServiceImpl;
    ModelMapper modelMapper;

    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository, ModelMapper modelMapper, ReportServiceImpl reportServiceImpl) {
        super(airportRepository, modelMapper, Airport.class, AirportDto.class);
        this.airportRepository = airportRepository;
        this.modelMapper = modelMapper;
        this.reportServiceImpl = reportServiceImpl;
    }

    @Override
    public Page<AirportDto> getPaginatedAirports(Pageable pageable) {
        Page<Airport> airports = airportRepository.findAll(pageable);
        List<AirportDto> airportDtos = new ArrayList<>();
        for (Airport airport : airports) {
            AirportDto airportDto = modelMapper.map(airport, AirportDto.class);
            airportDtos.add(airportDto);
        }
        return new PageImpl<>(airportDtos, pageable, airports.getTotalElements());

    }

    @Override
    public AirportDto save(AirportDto airportDto) {

        if(airportRepository.findByName(airportDto.getName()) != null)
            throw new RuntimeException("Airport Name Already Exists");
        if(airportRepository.findByCode(airportDto.getCode()) != null)
            throw new RuntimeException("Airport Code Already Exists");

        try {
            Airport airport = modelMapper.map(airportDto, Airport.class);
            airport = airportRepository.save(airport);
            return modelMapper.map(airport, AirportDto.class);
        } catch (RuntimeException e) {
            throw new RuntimeException("Airport already existed", e);
        }
    }
}

