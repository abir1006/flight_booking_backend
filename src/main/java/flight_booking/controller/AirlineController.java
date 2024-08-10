package flight_booking.controller;

import flight_booking.controller.genericcontroller.GenericController;
import flight_booking.dto.AirlineDto;
import flight_booking.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/airlines")
public class AirlineController extends GenericController<Long, AirlineDto> {
    @Autowired
    AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        super(airlineService);
    }
}
