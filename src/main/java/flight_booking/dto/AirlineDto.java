package flight_booking.dto;

import flight_booking.domain.Flight;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirlineDto {
    private Long id;
    private String airlineName;
    private String airlineLogo;
    private String country;
    private List<Flight> flights;
}
