package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.DiseaseStatus;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Requests.AddDiseaseStatusRequest;
import cancer.cssbackend.Repositories.DiseaseStatusRepository;
import cancer.cssbackend.Repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiseaseStatusService {
    private final DiseaseStatusRepository diseaseStatusRepository;
    private final PatientRepository patientRepository;

    public DiseaseStatus addDiseaseStatus(AddDiseaseStatusRequest addDiseaseStatusRequest) {
        DiseaseStatus diseaseStatus = addDiseaseStatusRequest.mapToDiseaseStatus();

        Optional<Patient> optionalPatient = patientRepository.findById(addDiseaseStatusRequest.getPatientID());
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            diseaseStatus.setPatient(patient);
        }

        diseaseStatusRepository.save(diseaseStatus);
        return diseaseStatus;
    }
}
