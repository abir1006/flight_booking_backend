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
    private Airport departureAirport;
    @OneToOne
    private Airport arrivalAirport;
    @OneToOne
    private FlightSchedule flightSchedule;

    private int availableSeats;

}
