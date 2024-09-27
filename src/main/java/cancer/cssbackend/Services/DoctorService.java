package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public Doctor findDoctor(Long doctorID){
        Optional<Doctor> doctor = doctorRepository.findById(doctorID);
        return doctor.orElseThrow(() -> new RuntimeException("Doctor not found with ID " + doctorID));
    }
}
