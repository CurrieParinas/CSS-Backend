package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByUser(User user);
}
