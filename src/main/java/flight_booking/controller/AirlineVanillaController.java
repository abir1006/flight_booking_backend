package flight_booking.controller;

import flight_booking.controller.genericcontroller.GenericController;
import flight_booking.dto.AirlineVanillaDto;
import flight_booking.service.AirlineVanillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/airlines")
public class AirlineVanillaController extends GenericController<Long, AirlineVanillaDto> {

    @Autowired
    AirlineVanillaService airlineVanillaService;

    public AirlineVanillaController(AirlineVanillaService airlineVanillaService) {

        super(airlineVanillaService);
    }
}
