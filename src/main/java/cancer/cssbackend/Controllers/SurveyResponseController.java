package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.SurveyResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/surveyresponse")
public class SurveyResponseController {
    private final SurveyResponseService surveyResponseService;
}
