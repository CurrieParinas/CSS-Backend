package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Projections.SymptomProjection;
import cancer.cssbackend.Services.SymptomSurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/symptom/survey")
public class SymptomSurveyController {
    private final SymptomSurveyService symptomSurveyService;

    @GetMapping("/symptomname/ls")
    public List<SymptomProjection> getSNbyCTLS(@RequestParam(value="cancerType") Long cancerType){
        return symptomSurveyService.getSNbyCTLS(cancerType);
    }
    @GetMapping("/symptomname/ss")
    public List<SymptomProjection> getSNbyCTSS(@RequestParam(value="cancerType") Long cancerType){
        return symptomSurveyService.getSNbyCTSS(cancerType);
    }
    @GetMapping("/symptomname/qol")
    public List<SymptomProjection> getSNbyCTQOL(@RequestParam(value="cancerType") Long cancerType){
        return symptomSurveyService.getSNbyCTQOL(cancerType);
    }
    @GetMapping("/symptomname/tse")
    public List<SymptomProjection> getSNbyCTTSE(@RequestParam(value="cancerType") Long cancerType){
        return symptomSurveyService.getSNbyCTTSE(cancerType);
    }
}
