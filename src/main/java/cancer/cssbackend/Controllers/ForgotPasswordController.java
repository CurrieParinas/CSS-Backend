package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.ForgotPasswordService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/forgotpassword")
public class ForgotPasswordController {
    private final ForgotPasswordService forgotPasswordService;

    @GetMapping("/createForgotPassword")
    public String createForgotPassword(@RequestParam("email") String email) throws MessagingException, IOException {
        return forgotPasswordService.createForgotPassword(email);
    }
    @GetMapping("/verifyUser")
    public Long verifyUser(@RequestParam("userId") Long userId, @RequestParam("token") String token) {
        return forgotPasswordService.verifyToken(userId, token);
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam("userId") Long userId, @RequestParam("password") String password) {
        return forgotPasswordService.changePassword(userId, password);
    }
}
