package flight_booking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import flight_booking.domain.Airline;
import flight_booking.domain.Airport;
import flight_booking.domain.FlightSchedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {

    private long id;
    private String flightNumber;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private FlightSchedule flightSchedule;
    private int availableSeats;
    private Double ticketPrice;
    private String airlineName;
    private String airlineLogo;
    private Airline airline;

    // Getters and Setters
}
