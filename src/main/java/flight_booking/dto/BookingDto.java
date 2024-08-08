package flight_booking.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
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
    private LocalDate returnDate;
    private Long returnFlightId;
    private Long flightId;
    private Long passengerId;
    private List<PassengerDto> passengers;
    private String ticket;
    private String airlineName;
    private String flightNumber;
    private String departureAirportName;
    private  String departureAirportCity;
    private String departureAirportCountry;
    private String codeDepartureAirport;
    private String arrivalAirportName;
    private String arrivalAirportCity;
    private String arrivalAirportCountry;
    private String codeArrivalAirport;

    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;

    private String returnAirlineName;
    private String returnFlightNumber;
    private String returnDepartureAirportName;
    private  String returnDepartureAirportCity;
    private String returnDepartureAirportCountry;
    private String returnCodeDepartureAirport;
    private String returnArrivalAirportName;
    private String returnArrivalAirportCity;
    private String returnArrivalAirportCountry;
    private String returnCodeArrivalAirport;

    private LocalDate returnDepartureDate;
    private LocalTime returnDepartureTime;
    private LocalDate returnArrivalDate;
    private LocalTime returnArrivalTime;

}

