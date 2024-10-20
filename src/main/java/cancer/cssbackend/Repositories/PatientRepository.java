package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByPatientId(Long patientId);
    Patient findByUser(User userToLogin);
}
