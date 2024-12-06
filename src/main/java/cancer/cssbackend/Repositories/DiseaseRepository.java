package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Disease;
import cancer.cssbackend.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    Disease findByPatient(Patient patient);


    @Query(value="SELECT * FROM Disease d WHERE d.PATIENT_ID = :patientID ORDER BY d.DISEASE_UPDATED_ON DESC FETCH FIRST 1 ROW ONLY", nativeQuery = true)
    Disease fetchByPatientID(@Param(("patientID")) Long patientID);
}
