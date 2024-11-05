package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Radiotherapy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;

@Repository
public interface RadiotherapyRepository extends JpaRepository<Radiotherapy, Long> {
    @Query(value = "SELECT DISTINCT d.DOCTOR_ID FROM DOCTOR d JOIN RADIOTHERAPY r ON r.RADRX_DOCTOR = d.DOCTOR_ID", nativeQuery = true)

    List<Long> fetchAllRadiotherapyDoctors();

    @Query(value = "SELECT DISTINCT d.DOCTOR_ID FROM DOCTOR d JOIN RADIOTHERAPY r ON r.RADRX_DOCTOR = d.DOCTOR_ID WHERE r.RADRX_FACILITY= :facilityID ", nativeQuery = true)
    List<Long> fetchRadiotherapyDoctorsByFacility(@Param("facilityID") Long facilityID);

    @Query(value = "SELECT DISTINCT H.HOSPITAL_ID FROM HOSPITAL H JOIN RADIOTHERAPY R ON H.HOSPITAL_ID = R.RADRX_FACILITY", nativeQuery = true)
    List<Long> fetchRadiotherapyFacilities();

    List<Radiotherapy> findByPatient(Patient patient);

    @Query(value="SELECT RADRX_ID FROM RADIOTHERAPY WHERE PATIENT_ID = :patientID", nativeQuery = true)
    List<Long> fetchLatestByPatient(@Param("patientID") Long patientID);

}
