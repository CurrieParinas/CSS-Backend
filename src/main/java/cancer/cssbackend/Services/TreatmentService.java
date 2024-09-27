package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Treatment;
import cancer.cssbackend.Repositories.TreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TreatmentService {
    private final TreatmentRepository treatmentRepository;
    public Treatment findTreatment(Long treatmentID){
        Optional<Treatment> treatment = treatmentRepository.findById(treatmentID);
        return treatment.orElseThrow(() -> new RuntimeException("Treatment not found with ID " + treatmentID));
    }
}
