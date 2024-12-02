package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.LabSubmitted;
import cancer.cssbackend.Entities.Requests.AddLabSubmittedRequest;
import cancer.cssbackend.Repositories.DoctorRepository;
import cancer.cssbackend.Repositories.LabSubmittedRepository;
import cancer.cssbackend.Repositories.PatientRepository;
import cancer.cssbackend.Repositories.WorkupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class LabSubmittedService {
    private final LabSubmittedRepository labSubmittedRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final WorkupRepository workupRepository;


    public LabSubmitted addLabSubmtited(AddLabSubmittedRequest addLabSubmittedRequest, MultipartFile labFileLocation) throws IOException {
        LabSubmitted labSubmitted = addLabSubmittedRequest.mapToLabSubmitted(patientRepository, doctorRepository, workupRepository);
        labSubmitted.setLabFileLocation(labFileLocation.getBytes());
        labSubmittedRepository.save(labSubmitted);
        return labSubmitted;
    }
}
