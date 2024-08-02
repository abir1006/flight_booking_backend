package flight_booking.controller;

import flight_booking.controller.genericcontroller.GenericController;
import flight_booking.dto.BookingRecordDto;
import flight_booking.service.BookingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/booking-records")
public class BookingRecordController extends GenericController<Long, BookingRecordDto> {

    @Autowired
    public BookingRecordController(BookingRecordService bookingRecordService) {
        super(bookingRecordService);
    }
}