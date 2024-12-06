package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.LabMonitor;
import cancer.cssbackend.Entities.LabSubmitted;
import cancer.cssbackend.Entities.Requests.AddLabSubmittedRequest;
import cancer.cssbackend.Repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LabSubmittedService {
    private final LabSubmittedRepository labSubmittedRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final WorkupRepository workupRepository;
    private final LabMonitorRepository labMonitorRepository;


    public LabSubmitted addLabSubmtited(AddLabSubmittedRequest addLabSubmittedRequest, MultipartFile labFileLocation) throws IOException {
        LabSubmitted labSubmitted = addLabSubmittedRequest.mapToLabSubmitted(patientRepository, doctorRepository, workupRepository);
        labSubmitted.setLabFileLocation(labFileLocation.getBytes());
        labSubmittedRepository.save(labSubmitted);
        LabMonitor labMonitor = new LabMonitor();
        labMonitor.setLabSubmitted(labSubmitted);
        LocalDateTime endDateTime = labSubmitted.getLabSubmissionDate().toLocalDateTime().plusMonths(labSubmitted.getWorkupName().getWorkupDuration());
        Date endDate = Date.valueOf(endDateTime.toLocalDate());
        labMonitor.setEndDate(endDate);
        labMonitorRepository.save(labMonitor);
        return labSubmitted;
    }

    public List<LabSubmitted> getAllSubmissions() {
        return labSubmittedRepository.findAll();
    }
}
