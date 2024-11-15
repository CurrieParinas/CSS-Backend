package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Consult;
import cancer.cssbackend.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultRepository extends JpaRepository<Consult, Long> {
    List<Consult> findByPatient(Patient patient);
}
