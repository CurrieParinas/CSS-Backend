package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Chemotherapy;
import cancer.cssbackend.Entities.Requests.AddChemotherapyRequest;
import cancer.cssbackend.Entities.Requests.AddSurgeryRequest;
import cancer.cssbackend.Entities.Surgery;
import cancer.cssbackend.Services.SurgeryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/surgery")
public class SurgeryController {
    private final SurgeryService surgeryService;
    @PostMapping("/add")
    public Surgery addSurgery(@RequestBody AddSurgeryRequest addSurgeryRequest) {
        return surgeryService.addSurgery(addSurgeryRequest);
    }
}
