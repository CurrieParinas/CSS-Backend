package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Chemotherapy;
import cancer.cssbackend.Entities.Radiotherapy;
import cancer.cssbackend.Entities.Requests.AddChemotherapyRequest;
import cancer.cssbackend.Entities.Requests.AddRadiotherapyRequest;
import cancer.cssbackend.Services.RadiotherapyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/radiotherapy")
public class RadiotherapyController {
    private final RadiotherapyService radiotherapyService;

    @PostMapping("/add")
    public Radiotherapy addRadiotherapy(@RequestBody AddRadiotherapyRequest addRadiotherapyRequest) {
        return radiotherapyService.addRadiotherapy(addRadiotherapyRequest);
    }
}
