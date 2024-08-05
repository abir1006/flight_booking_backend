package flight_booking.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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

    //status could be .1. Pending 2. booked with payment(Confirm booking) 3. e ticket generated/msg sent
    private String status;

    private String tripType;

    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;


    //    @OneToOne
//    @JoinColumn(name = "passenger_id")
//    private User passenger;
    //Changed the relationship in order for the booking to have multiple passengers
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Passenger> passengers;





}
