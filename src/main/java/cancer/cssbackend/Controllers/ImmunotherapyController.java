package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Chemotherapy;
import cancer.cssbackend.Entities.Immunotherapy;
import cancer.cssbackend.Entities.Requests.AddChemotherapyRequest;
import cancer.cssbackend.Entities.Requests.AddImmunotherapyRequest;
import cancer.cssbackend.Services.ImmunotherapyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/immunotherapy")
public class ImmunotherapyController {
    private final ImmunotherapyService immunotherapyService;

    @PostMapping("/add")
    public Immunotherapy addImmunotherapy(@RequestBody AddImmunotherapyRequest addImmunotherapyRequest) {
        return immunotherapyService.addImmunotherapy(addImmunotherapyRequest);
    }
}
