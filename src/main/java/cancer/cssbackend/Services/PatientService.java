package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.User;
import cancer.cssbackend.Repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public Patient findPatient(Long patientID){
        Optional<Patient> patient = patientRepository.findById(patientID);
        return patient.orElseThrow(() -> new RuntimeException("Patient not found with ID " + patientID));
    }
}
