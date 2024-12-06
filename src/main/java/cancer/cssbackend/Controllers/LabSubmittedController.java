package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.LabSubmitted;
import cancer.cssbackend.Entities.Requests.AddDoctorRequest;
import cancer.cssbackend.Entities.Requests.AddLabSubmittedRequest;
import cancer.cssbackend.Services.LabSubmittedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/lab/submit")
public class LabSubmittedController {
    private final LabSubmittedService labSubmittedService;

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public LabSubmitted addLabSubmitted(@RequestPart("addLabSubmittedRequest") AddLabSubmittedRequest addLabSubmittedRequest,
                                        @RequestPart("labFileLocation") MultipartFile labFileLocation) throws IOException {
        return labSubmittedService.addLabSubmtited(addLabSubmittedRequest, labFileLocation);
    }

    @GetMapping(value = "/all")
    public List<LabSubmitted> getAllSubmissions() {
        return labSubmittedService.getAllSubmissions();
    }
}