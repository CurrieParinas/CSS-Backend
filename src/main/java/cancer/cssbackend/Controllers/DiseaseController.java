package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Disease;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Requests.AddDiseaseRequest;
import cancer.cssbackend.Entities.Requests.AddPatientRequest;
import cancer.cssbackend.Services.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/disease")
public class DiseaseController {
    private final DiseaseService diseaseService;

    @PostMapping("/add")
    public Disease addDisease(@RequestBody AddDiseaseRequest addDiseaseRequest) {
        return diseaseService.addDisease(addDiseaseRequest);
    }
}
