package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Requests.LoginRequest;
import cancer.cssbackend.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Object user = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
        if (user != null) {
            // User found, handle successful login
            return ResponseEntity.ok(user);
        } else {
            // User not found
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
        }
    }
}
