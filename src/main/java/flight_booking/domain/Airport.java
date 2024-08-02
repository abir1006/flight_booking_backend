package flight_booking.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="airports")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique=true, nullable=false)
    private String name;
    private String city;
    private String country;
    @Column(unique = true, nullable = false)
    private String code;


}
