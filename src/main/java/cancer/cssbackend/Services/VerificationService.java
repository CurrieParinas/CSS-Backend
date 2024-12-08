package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.User;
import cancer.cssbackend.Entities.Verification;
import cancer.cssbackend.Repositories.UserRepository;
import cancer.cssbackend.Repositories.VerificationRepository;
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
public class VerificationService {
    private final VerificationRepository verificationRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;

    public String createVerification(Long userId) throws MessagingException, IOException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getUserIsVerified() == 'Y') {
                return "User is already verified.";
            }
            String token = UUID.randomUUID().toString();
            LocalDateTime expiryDate = LocalDateTime.now().plusMinutes(5);
            Verification verification = verificationRepository.findByUser(user);
            if (verification == null) {
                verification = new Verification();
                verification.setUser(user);
            }
            verification.setToken(token);
            verification.setExpiry(Timestamp.valueOf(expiryDate));
            emailService.sendHtmlEmail('v', user.getUserEmail(), "Account Verification", user.getUserId(), token);
            verificationRepository.save(verification);
            return "Verification mail sent.";
        }
        return "User does not exist.";
    }

    public String verifyToken(Long userId, String token) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Verification verification = verificationRepository.findByUserAndToken(user, token);
            if (verification == null) {
                return "Invalid token.";
            } else if (verification.isExpired()) {
                return "Token has expired.";
            }

            user.setUserIsVerified('Y');
            userRepository.save(user);
            return "Account verified successfully!";
        }
        return "User does not exist.";
    }
}
