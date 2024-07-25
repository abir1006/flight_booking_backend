package flight_booking.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate bookingDate;

    private String status;

    @OneToOne
    @JoinColumn(name="flight_id")
    private Flight flight;

    @OneToOne
    @JoinColumn(name = "passenger_id")
    private User passenger;



}
