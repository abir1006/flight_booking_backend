package flight_booking.service;

import flight_booking.domain.Role;
import flight_booking.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService extends GenericService<Long, UserDto> {

    public UserDto getUserByEmail(String email);

    public List<UserDto> getAllByRole(Role role);

    public Page<UserDto>  getAllByRole(Role role, Pageable pageable);


}
