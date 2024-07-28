package flight_booking.service;

import flight_booking.dto.UserDto;

public interface UserService extends GenericService<Long, UserDto> {

    public UserDto getUserByEmail(String email);
}
