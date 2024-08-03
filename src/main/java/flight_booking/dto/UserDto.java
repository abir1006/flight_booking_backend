package flight_booking.dto;


import flight_booking.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String address;
    private Role role;
}
