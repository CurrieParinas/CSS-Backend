package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.DiseaseStatus;
import cancer.cssbackend.Entities.Requests.AddDiseaseStatusRequest;
import cancer.cssbackend.Services.DiseaseStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/diseasestatus")
public class DiseaseStatusController {
    private final DiseaseStatusService diseaseStatusService;

    @PostMapping("/add")
    public DiseaseStatus addDiseaseStatus(@RequestBody AddDiseaseStatusRequest addDiseaseStatusRequest) {
        return diseaseStatusService.addDiseaseStatus(addDiseaseStatusRequest);
    }
}
