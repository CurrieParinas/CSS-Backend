package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.ForgotPassword;
import cancer.cssbackend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForgotPasswordRepository extends JpaRepository<ForgotPassword, Long> {
    ForgotPassword findByUserAndToken(User user, String token);
    ForgotPassword findByUser(User user);
}
