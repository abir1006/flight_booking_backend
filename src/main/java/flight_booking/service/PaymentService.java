package flight_booking.service;



import flight_booking.dto.PaymentDto;

public interface PaymentService extends GenericService<Long, PaymentDto> {
    boolean confirmBooking(Long bookingId);


}

