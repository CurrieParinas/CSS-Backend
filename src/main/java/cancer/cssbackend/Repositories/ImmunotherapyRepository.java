package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.Immunotherapy;
import cancer.cssbackend.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImmunotherapyRepository extends JpaRepository<Immunotherapy, Long> {
    @Query(value="SELECT DISTINCT d.DOCTOR_ID FROM DOCTOR d JOIN IMMUNOTHERAPY i ON i.IMMUNORX_DOCTOR = d.DOCTOR_ID", nativeQuery = true)
    public List<Long> fetchAllDoctors();

    @Query(value = "SELECT DISTINCT d.DOCTOR_ID FROM DOCTOR d JOIN IMMUNOTHERAPY i ON i.IMMUNORX_DOCTOR = d.DOCTOR_ID WHERE i.IMMUNORX_FACILITY= :facilityID", nativeQuery = true)
    public List<Long> fetchImmunotherapyDoctorsByFacility(@Param("facilityID") Long facilityID);

    @Query(value = "SELECT DISTINCT H.HOSPITAL_ID FROM HOSPITAL H JOIN IMMUNOTHERAPY I ON H.HOSPITAL_ID = I.IMMUNORX_FACILITY", nativeQuery = true)
    public List<Long> fetchImmunotherapyFacilities();

    List<Immunotherapy> findByPatient(Patient patient);

    @Query(value="SELECT IMMUNORX_ID FROM IMMUNOTHERAPY WHERE PATIENT_ID = :patientID", nativeQuery = true)
    List<Long> fetchLatestByPatient(@Param("patientID") Long patientID);

}
