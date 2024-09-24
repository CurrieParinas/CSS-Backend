package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.User;
import cancer.cssbackend.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Map<String, Object> loginUser(String email, String password) {
        User userToLogin = userRepository.findByUserEmailAndUserPassword(email, password);

        //if doctor yung user, return kasama yung doctor table infos
        if (userToLogin != null && userToLogin.getUserRole().getRoleId() == 2) {
            return userRepository.returnValidDoctor(email, password);
        }
        // if patient
        //else if (userToLogin != null && userToLogin.getUserRole().getRoleId() == 3) {}
        // If no valid user or role is found, return null or handle errors
        else {
            return null;
        }
    }

    public User getUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(() -> new RuntimeException("User not found with ID " + userId));
    }

    public Map<String, Object> returnValidDoctor(String email, String password){
        return userRepository.returnValidDoctor(email, password);
    }
}
