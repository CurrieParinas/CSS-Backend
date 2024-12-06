package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.Hospital;
import cancer.cssbackend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByUser(User user);

    List<Doctor> findByHospital(Hospital hospital);

    @Query(value = "SELECT DISTINCT d.DOCTOR_ID FROM SURGERY s JOIN DOCTOR d ON s.SURGERY_SURGEON = d.DOCTOR_ID", nativeQuery = true)
    List<Long> findAllSurgeons();

    @Query(value = "SELECT DISTINCT d.DOCTOR_ID FROM DOCTOR d JOIN SURGERY s ON s.SURGERY_SURGEON = d.DOCTOR_ID WHERE d.DOCTOR_HOSPITAL = :hospitalID", nativeQuery = true)
    List<Long> findSurgeonsByHosp(@Param("hospitalID") Long hospitalID);

    @Query(value="SELECT DISTINCT D.DOCTOR_ID FROM DOCTOR D INNER JOIN ONBOARD O ON D.DOCTOR_ID = O.DOCTOR_ID WHERE O.PATIENT_ID = :patientID", nativeQuery = true)
    List<Long> fetchDoctorsOfAPatient(@Param("patientID") Long patientID);
}
