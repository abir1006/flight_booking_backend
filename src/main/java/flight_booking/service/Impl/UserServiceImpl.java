package flight_booking.service.Impl;


import flight_booking.domain.Airport;
import flight_booking.domain.Role;
import flight_booking.dto.AirportDto;
import flight_booking.repositories.UserRepository;
import flight_booking.domain.User;
import flight_booking.dto.UserDto;
import flight_booking.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long, UserDto> implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        super(userRepository, modelMapper, User.class, UserDto.class);
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;


    }

    @Override
    public UserDto getUserByEmail(String email) {

        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDto.class);
        }
        else throw new UsernameNotFoundException("Email Not Found");
    }

    @Override
    public List<UserDto> getAllByRole(Role role) {
        List<User> users = userRepository.findAllByRole(role);
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(modelMapper.map(user, UserDto.class));
        }
        return userDtos;
    }

    @Override
    public Page<UserDto> getAllByRole(Role role, Pageable pageable) {
        Page<User> users = userRepository.findAllByRole(role,pageable);
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = modelMapper.map(user, UserDto.class);
            userDtos.add(userDto);
        }
        return new PageImpl<>(userDtos, pageable, users.getTotalElements());

    }


}
