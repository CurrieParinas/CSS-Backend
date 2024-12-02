package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByPatientId(Long patientId);
    Patient findByUser(User userToLogin);

    @Query(value = "SELECT p.* FROM PATIENT p JOIN ONBOARD o ON p.PATIENT_ID = o.PATIENT_ID WHERE o.DOCTOR_ID = :doctorID AND p.PATIENT_CREATED_ON = (SELECT MAX(p2.PATIENT_CREATED_ON) FROM PATIENT p2 JOIN ONBOARD o2 ON p2.PATIENT_ID = o2.PATIENT_ID WHERE o2.DOCTOR_ID = :doctorID) AND p.PATIENT_ID = (SELECT MAX(p3.PATIENT_ID) FROM PATIENT p3 JOIN ONBOARD o3 ON p3.PATIENT_ID = o3.PATIENT_ID WHERE o3.DOCTOR_ID = :doctorID AND p3.PATIENT_CREATED_ON = (SELECT MAX(p4.PATIENT_CREATED_ON) FROM PATIENT p4 JOIN ONBOARD o4 ON p4.PATIENT_ID = o4.PATIENT_ID WHERE o4.DOCTOR_ID = :doctorID))", nativeQuery = true)
    Patient fetchLatestCreatedPatient(@Param(("doctorID")) Long doctorID);
}
