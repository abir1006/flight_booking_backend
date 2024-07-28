package flight_booking.auth;

import flight_booking.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {

        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/change-password")
    public ResponseEntity<Void> changePassword(@RequestBody ChangePasswordRequest request) {
        service.changePassword(request);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/admin/{email}")
    public ResponseEntity<UserDto> getByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(service.getByEmail(email));
    }

    @GetMapping("/admin")
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @DeleteMapping("/admin/{email}")
    public ResponseEntity<Void> delete(@PathVariable("email") String email) {
        service.removeEmail(email);
        return ResponseEntity.noContent().build();
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccess", false);
        map.put("error", exception.getMessage());
        map.put("status", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }
}
