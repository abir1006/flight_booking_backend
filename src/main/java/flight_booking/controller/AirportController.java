package flight_booking.controller;

import flight_booking.domain.Airport;
import flight_booking.dto.AirportDto;
import flight_booking.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/airports")
public class AirportController extends GenericController<Long, AirportDto> {

    @Autowired
    public AirportController(AirportService airportService) {
        super(airportService);
    }
    //add new different controllers


}
