package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.VerificationService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/verification")
public class VerificationController {
    private final VerificationService verificationService;

    @GetMapping("/createVerification")
    public String createVerification(@RequestParam("userId") Long userId) throws MessagingException, IOException {
        return verificationService.createVerification(userId);
    }
    @GetMapping("/verifyUser")
    public String verifyAccount(@RequestParam("userId") Long userId, @RequestParam("token") String token) {
        return verificationService.verifyToken(userId, token);
    }
}
