package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    List<Treatment> findByPatient(Patient patient);
}
