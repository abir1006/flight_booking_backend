package flight_booking.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String flightNumber;
    @OneToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;
    @OneToOne
    @JoinColumn(name="arrival_airport_id")
    private Airport arrivalAirport;
    @Embedded
    private FlightSchedule flightSchedule;

    private int availableSeats;

    private String flightLogo;

    //its equal for all kind of seats ..no seat classes
    private double ticketPrice;



}
