package flight_booking.dto;

import flight_booking.domain.Flight;
import flight_booking.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRecordDto {
    private Long id;
    private LocalDate bookingDate;
    private String status;
    private Flight flight;
    private User passenger;
}