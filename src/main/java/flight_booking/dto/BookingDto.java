package flight_booking.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDto {
    private Long id;
    private LocalDate bookingDate;
    private String status;
    private String tripType;
    private Double totalPrice;
    private List<Long> flightIds;
    private Long passengerId;
    private List<PassengerDto> passengers;
    private String ticket;

}

