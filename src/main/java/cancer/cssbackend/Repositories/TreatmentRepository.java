package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    List<Treatment> findByPatient(Patient patient);

    @Query(value="SELECT TREATMENT_ID FROM TREATMENT WHERE PATIENT_ID = :patientID", nativeQuery = true)
    List<Long> fetchLatestByPatient(@Param("patientID") Long patientID);
}
