package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.SymptomSurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/symptom/survey")
public class SymptomSurveyController {
    private final SymptomSurveyService symptomSurveyService;
}
