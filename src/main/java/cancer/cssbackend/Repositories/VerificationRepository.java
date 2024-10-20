package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.User;
import cancer.cssbackend.Entities.Verification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationRepository extends JpaRepository<Verification, Long> {
    Verification findByUserAndToken(User user, String token);
    Verification findByUser(User user);
}
