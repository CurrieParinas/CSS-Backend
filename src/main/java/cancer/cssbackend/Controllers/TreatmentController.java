package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Requests.AddTreatmentRequest;
import cancer.cssbackend.Entities.Treatment;
import cancer.cssbackend.Services.TreatmentService;
import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/treatment")
public class TreatmentController {
    private final TreatmentService treatmentService;

    @PostMapping("/add")
    public Treatment addTreatment(@RequestBody AddTreatmentRequest addTreatmentRequest) {
        return treatmentService.addTreatment(addTreatmentRequest);
    }
}
