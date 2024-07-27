package flight_booking.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccess", false);
        map.put("error", exception.getMessage());
        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<Object>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
