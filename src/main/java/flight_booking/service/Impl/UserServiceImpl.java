package flight_booking.service.Impl;


import flight_booking.config.securityConfig.UserRepository;
import flight_booking.domain.User;
import flight_booking.dto.UserDto;
import flight_booking.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long, UserDto> implements UserService {


    UserRepository userRepository;
    ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ModelMapper modelMapper1) {
        super(userRepository, modelMapper, User.class, UserDto.class);


    }

    @Override
    public UserDto getUserByEmail(String email) {

        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDto.class);
        }
        else throw new UsernameNotFoundException("Email Not Found");
    }
}
