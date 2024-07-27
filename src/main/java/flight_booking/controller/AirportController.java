package flight_booking.controller;

import flight_booking.domain.Airport;
import flight_booking.service.AirportService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/airports")
public class AirportController extends GenericController<Airport,Long>{

    AirportService airportService;


    public AirportController(AirportService airportService) {
        super(airportService);
        this.airportService=airportService;
    }

    @Override
    protected Airport updateId(Airport entity, Long id) {

        entity.setId(id);

        return entity;
    }
}
