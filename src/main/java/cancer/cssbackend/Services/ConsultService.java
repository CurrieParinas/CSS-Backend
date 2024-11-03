package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Consult;
import cancer.cssbackend.Entities.DiseaseStatus;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Requests.AddConsultRequest;
import cancer.cssbackend.Repositories.ConsultRepository;
import cancer.cssbackend.Repositories.DiseaseStatusRepository;
import cancer.cssbackend.Repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultService {
    private final ConsultRepository consultRepository;
    private final PatientRepository patientRepository;
    private final DiseaseStatusRepository diseaseStatusRepository;

    public Consult addConsult(AddConsultRequest addConsultRequest) {
        Consult consult = addConsultRequest.mapToConsult();

        Optional<Patient> optionalPatient = patientRepository.findById(addConsultRequest.getPatientID());
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            consult.setPatient(patient);
        }

        Optional<DiseaseStatus> optionalDiseaseStatus = diseaseStatusRepository.findById(addConsultRequest.getConsultPatientstatus());
        if (optionalDiseaseStatus.isPresent()) {
            DiseaseStatus diseaseStatus = optionalDiseaseStatus.get();
            consult.setConsultPatientstatus(diseaseStatus);
        }

        consultRepository.save(consult);
        return consult;
    }
}
