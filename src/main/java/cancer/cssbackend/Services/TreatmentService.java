package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Requests.AddTreatmentRequest;
import cancer.cssbackend.Entities.Treatment;
import cancer.cssbackend.Repositories.RxTypeRepository;
import cancer.cssbackend.Repositories.TreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TreatmentService {
    private final TreatmentRepository treatmentRepository;
    private final RxTypeRepository rxTypeRepository;
    private final PatientService patientService;
    private final RxTypeService rxTypeService;
    private final UserService userService;
    public Treatment findTreatment(Long treatmentID){
        Optional<Treatment> treatment = treatmentRepository.findById(treatmentID);
        return treatment.orElseThrow(() -> new RuntimeException("Treatment not found with ID " + treatmentID));
    }

    public Treatment addTreatment(AddTreatmentRequest addTreatmentRequest){
        Treatment treatment = addTreatmentRequest.mapToTreatment(patientService, rxTypeService, userService);
        if (treatment.getTreatmentPlan() != null) {
            if(treatment.getTreatmentPlan().getRxtypeId() == null){
                rxTypeRepository.save(treatment.getTreatmentPlan());
            }
        }
        treatmentRepository.save(treatment);

        return treatment;
    }
}
