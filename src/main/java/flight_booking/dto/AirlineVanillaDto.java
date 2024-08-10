package flight_booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirlineVanillaDto {

        private Long id;
        private String airlineName;
        private String airlineLogo;
        private String country;
}
