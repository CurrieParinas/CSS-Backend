package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.DiseaseStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/diseasestatus")
public class DiseaseStatusController {
    private final DiseaseStatusService diseaseStatusService;
}
