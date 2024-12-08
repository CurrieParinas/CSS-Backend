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

    public String createForgotPassword(String email) throws MessagingException, IOException {
        User user = userRepository.findByUserEmail(email);
        if (user == null) {
            return "User does not exist.";
        }
        String token = UUID.randomUUID().toString();
        LocalDateTime expiryDate = LocalDateTime.now().plusMinutes(5);
        ForgotPassword forgotPassword = forgotPasswordRepository.findByUser(user);
        if (forgotPassword == null) {
            forgotPassword = new ForgotPassword();
            forgotPassword.setUser(user);
        }
        forgotPassword.setToken(token);
        forgotPassword.setExpiry(Timestamp.valueOf(expiryDate));
        emailService.sendHtmlEmail('f', email, "Account Verification", user.getUserId(), token);
        forgotPasswordRepository.save(forgotPassword);
        return "Password Reset mail sent.";
    }

    public Long verifyToken(Long userId, String token) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            ForgotPassword forgotPassword = forgotPasswordRepository.findByUserAndToken(user, token);
            if (forgotPassword == null) {
                return null;
            } else if (forgotPassword.isExpired()) {
                return 0L;
            }
            return user.getUserId();
        }
        return null;
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
