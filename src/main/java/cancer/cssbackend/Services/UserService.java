package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.User;
import cancer.cssbackend.Repositories.DoctorRepository;
import cancer.cssbackend.Repositories.OnboardRepository;
import cancer.cssbackend.Repositories.PatientRepository;
import cancer.cssbackend.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public Object loginUser(String email, String password) {
        User userToLogin = userRepository.findByUserEmailAndUserPassword(email, password);

        if (userToLogin != null && userToLogin.getUserRole().getRoleId() == 2) {
            return doctorRepository.findByUser(userToLogin);
        } else if (userToLogin != null && userToLogin.getUserRole().getRoleId() == 3) {
            return patientRepository.findByUser(userToLogin);
        } else {
            return null;
        }
    }

    public User getUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(() -> new RuntimeException("User not found with ID " + userId));
    }

    public void deleteUser(Long userID){
        Optional<User> userToDelete = userRepository.findById(userID);
        userToDelete.ifPresent(userRepository::delete);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String editStatus(Long userID, String userStatus){
        Optional<User> user = userRepository.findById(userID);

        if(user.isPresent()){
            user.get().setUserStatus(userStatus);
            user.get().setUserUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));
            userRepository.save(user.get());
            return "Successfully updated User's Status";
        } else{
            throw new RuntimeException("User not found with ID: " + userID);
        }
    }
}
