package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
    @Query(value="SELECT DISTINCT H.HOSPITAL_ID FROM HOSPITAL H JOIN SURGERY S ON H.HOSPITAL_ID = S.SURGERY_HOSPITAL", nativeQuery = true)
    List<Long> fetchSurgeryHospitals();

    List<Surgery> findByPatient(Patient patient);

    @Query(value="SELECT SURGERY_ID FROM SURGERY WHERE PATIENT_ID = :patientID", nativeQuery = true)
    List<Long> fetchLatestByPatient(@Param("patientID") Long patientID);

}
