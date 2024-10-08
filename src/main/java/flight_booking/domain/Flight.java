package flight_booking.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name="arrival_airport_id")
    private Airport arrivalAirport;

    @Embedded
    private FlightSchedule flightSchedule;

    private int availableSeats;

    private double ticketPrice;

    @ManyToOne
    @JoinColumn(name = "airline_id")

    private Airline airline;
}
