package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Hormonal;
import cancer.cssbackend.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HormonalRepository extends JpaRepository<Hormonal, Long> {
    @Query(value = "SELECT DISTINCT d.DOCTOR_ID FROM DOCTOR d JOIN HORMONAL h ON h.HORMONAL_DOCTOR = d.DOCTOR_ID", nativeQuery = true)
    List<Long> fetchAllHormonalDoctors();

    @Query(value = "SELECT DISTINCT H.HOSPITAL_ID FROM HOSPITAL H JOIN DOCTOR D ON H.HOSPITAL_ID = D.DOCTOR_HOSPITAL JOIN HORMONAL HM ON D.DOCTOR_ID = HM.HORMONAL_DOCTOR", nativeQuery = true)
    List<Long> fetchHormonalHospitals();

    List<Hormonal> findByPatient(Patient patient);

    @Query(value="SELECT HORMONAL_ID FROM HORMONAL WHERE PATIENT_ID = :patientID", nativeQuery = true)
    List<Long> fetchLatestByPatient(@Param("patientID") Long patientID);

}
