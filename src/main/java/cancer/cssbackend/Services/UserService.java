package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.User;
import cancer.cssbackend.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User loginUser(String email, String password) {
        return userRepository.findByUserEmailAndUserPassword(email, password);
    }

    public User getUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(() -> new RuntimeException("User not found with ID " + userId));
    }
}
