package flight_booking.controller;

import flight_booking.controller.genericcontroller.GenericController;
import flight_booking.dto.PassengerDto;
import flight_booking.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/passengers")
public class PassengerController extends GenericController<Long, PassengerDto> {

    @Autowired
    public PassengerController(PassengerService passengerService) {
        super(passengerService);
    }
}