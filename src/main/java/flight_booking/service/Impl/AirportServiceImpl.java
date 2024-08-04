package flight_booking.service.Impl;


import flight_booking.domain.Airport;
import flight_booking.dto.AirportDto;
import flight_booking.repositories.AirportRepository;
import flight_booking.service.AirportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


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

