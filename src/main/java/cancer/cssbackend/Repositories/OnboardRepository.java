package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.Onboard;
import cancer.cssbackend.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OnboardRepository extends JpaRepository<Onboard, Long> {

    List<Onboard> findAllByDoctor(Optional<Doctor> doctor);

    List<Onboard> findByPatient(Optional<Patient> patient);
}
