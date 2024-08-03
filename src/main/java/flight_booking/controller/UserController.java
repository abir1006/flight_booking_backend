package flight_booking.controller;

import flight_booking.controller.genericcontroller.GenericController;
import flight_booking.dto.UserDto;
import flight_booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/admin/users")
public class UserController extends GenericController<Long, UserDto> {

    @Autowired
    UserService userService;


    public UserController(UserService service) {
        super(service);
    }



    @GetMapping("/{email}")
    public ResponseEntity<UserDto> getByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

//    @GetMapping("/admin")
//    public ResponseEntity<List<UserDto>> getAll() {
//        return ResponseEntity.ok(service.getAllUsers());
//    }
//
//    @DeleteMapping("/admin/{email}")
//    public ResponseEntity<Void> delete(@PathVariable("email") String email) {
//        service.removeEmail(email);
//        return ResponseEntity.noContent().build();
//    }

}
