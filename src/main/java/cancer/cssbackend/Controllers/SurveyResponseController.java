package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Requests.AddSurveyResponseRequest;
import cancer.cssbackend.Entities.Requests.AddTreatmentRequest;
import cancer.cssbackend.Entities.SurveyResponse;
import cancer.cssbackend.Entities.Treatment;
import cancer.cssbackend.Services.SurveyResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/surveyresponse")
public class SurveyResponseController {
    private final SurveyResponseService surveyResponseService;

    @PostMapping("/add")
    public SurveyResponse addSurveyResponse(@RequestBody AddSurveyResponseRequest addSurveyResponseRequest) {
        return surveyResponseService.addSurveyResponse(addSurveyResponseRequest);
    }

    @GetMapping("/existing")
    public SurveyResponse fetchExistingSurveyResponse(@RequestParam(value="patientID") Long patientID, @RequestParam(value="doctorID") Long doctorID){
        return surveyResponseService.fetchExistingSurveyResponse(patientID, doctorID);
    }
}
