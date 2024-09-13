package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
