package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.LabSubmitted;
import cancer.cssbackend.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabSubmittedRepository extends JpaRepository<LabSubmitted, Long> {
    List<LabSubmitted> findByPatient(Patient patient);

    List<LabSubmitted> findByDoctor(Doctor doctor);
}
