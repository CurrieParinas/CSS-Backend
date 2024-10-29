package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Chemotherapy;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Requests.AddChemotherapyRequest;
import cancer.cssbackend.Entities.Requests.AddPatientRequest;
import cancer.cssbackend.Services.ChemotherapyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/chemotherapy")
public class ChemotherapyController {
    private final ChemotherapyService chemotherapyService;

    @PostMapping("/add")
    public Chemotherapy addChemotherapy(@RequestBody AddChemotherapyRequest addChemotherapyRequest) {
        return chemotherapyService.addChemotherapy(addChemotherapyRequest);
    }
}
