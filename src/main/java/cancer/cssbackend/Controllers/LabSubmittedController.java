package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.LabSubmitted;
import cancer.cssbackend.Entities.Requests.AddDoctorRequest;
import cancer.cssbackend.Entities.Requests.AddLabSubmittedRequest;
import cancer.cssbackend.Services.LabSubmittedService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/lab/submit")
public class LabSubmittedController {
    private final LabSubmittedService labSubmittedService;

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public LabSubmitted addLabSubmitted(@RequestPart("addLabSubmittedRequest") AddLabSubmittedRequest addLabSubmittedRequest,
                                        @RequestPart("labFileLocation") MultipartFile labFileLocation) throws IOException, MessagingException {
        return labSubmittedService.addLabSubmitted(addLabSubmittedRequest, labFileLocation);
    }

    @PostMapping(value = "/addNoMonitoring", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public LabSubmitted addLabSubmittedNoMonitoring(@RequestPart("addLabSubmittedRequest") AddLabSubmittedRequest addLabSubmittedRequest,
                                        @RequestPart("labFileLocation") MultipartFile labFileLocation) throws IOException, MessagingException {
        return labSubmittedService.addLabSubmittedNoMonitoring(addLabSubmittedRequest, labFileLocation);
    }

    @GetMapping(value = "/all")
    public List<Map<String, Object>> getAllSubmissions() {
        return labSubmittedService.getAllSubmissions();
    }

    @GetMapping(value = "/getSubmissionByDoctor/{doctorId}")
    public List<Map<String, Object>> getSubmissionByDoctor(@PathVariable Long doctorId) {
        return labSubmittedService.getSubmissionByDoctor(doctorId);
    }
}