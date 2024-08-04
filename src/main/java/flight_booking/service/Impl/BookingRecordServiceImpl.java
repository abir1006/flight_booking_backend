package flight_booking.service.Impl;

import flight_booking.domain.BookingRecord;
import flight_booking.dto.BookingRecordDto;
import flight_booking.repositories.BookingRecordRepository;
import flight_booking.service.BookingRecordService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingRecordServiceImpl extends GenericServiceImpl<BookingRecord, Long, BookingRecordDto> implements BookingRecordService {

    @Autowired
    public BookingRecordServiceImpl(BookingRecordRepository bookingRecordRepository, ModelMapper modelMapper) {
        super(bookingRecordRepository, modelMapper, BookingRecord.class, BookingRecordDto.class);
    }
}