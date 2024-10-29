package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Disease;
import cancer.cssbackend.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
    Disease findByPatient(Patient patient);
}
