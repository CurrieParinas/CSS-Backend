package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/treatment")
public class TreatmentController {
    private final TreatmentService treatmentService;
}
