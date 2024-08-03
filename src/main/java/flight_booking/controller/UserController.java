package flight_booking.controller;

import flight_booking.controller.genericcontroller.GenericController;
import flight_booking.domain.Role;
import flight_booking.dto.AirportDto;
import flight_booking.dto.UserDto;
import flight_booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/admin/users")
public class UserController extends GenericController<Long, UserDto> {

    @Autowired
    UserService userService;


    public UserController(UserService service) {
        super(service);
    }


    @GetMapping("/email")
    public ResponseEntity<UserDto> getUserByEmail(@RequestParam(value = "email") String id){
        return ResponseEntity.ok(userService.getUserByEmail(id));
    }

//    @GetMapping("/passengers")
//    public ResponseEntity<List<UserDto>> getUserByPassengers(){
//        return ResponseEntity.ok(userService.getAllByRole(Role.USER));
//
//    }


    @GetMapping("/passengers")
    public Page<UserDto> getAllPassengers(
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userService.getAllByRole(Role.USER,pageable);


    }




}
