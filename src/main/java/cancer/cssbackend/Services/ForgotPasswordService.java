package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.ForgotPassword;
import cancer.cssbackend.Entities.User;
import cancer.cssbackend.Repositories.ForgotPasswordRepository;
import cancer.cssbackend.Repositories.UserRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ForgotPasswordService {
    private final ForgotPasswordRepository forgotPasswordRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;

    public String createForgotPassword(Long userId) throws MessagingException, IOException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String token = UUID.randomUUID().toString();
            LocalDateTime expiryDate = LocalDateTime.now().plusMinutes(5);
            ForgotPassword forgotPassword = forgotPasswordRepository.findByUser(user);
            if (forgotPassword == null) {
                forgotPassword = new ForgotPassword();
                forgotPassword.setUser(user);
            }
            forgotPassword.setToken(token);
            forgotPassword.setExpiry(Timestamp.valueOf(expiryDate));
            emailService.sendHtmlEmail("forgot", user.getUserEmail(), "Account Verification", user.getUserId(), token);
            forgotPasswordRepository.save(forgotPassword);
            return "Password Reset mail sent.";
        }
        return "User does not exist.";
    }

    public String verifyToken(Long userId, String token) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            ForgotPassword forgotPassword = forgotPasswordRepository.findByUserAndToken(user, token);
            if (forgotPassword == null) {
                return "Invalid token.";
            } else if (forgotPassword.isExpired()) {
                return "Token has expired.";
            }
            return "User verified successfully.";
        }
        return "User does not exist.";
    }

    public String changePassword(Long userId, String password) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUserPassword(password);
            userRepository.save(user);
            return "Password changed successfully!";
        }
        return "User does not exist.";
    }
}
