package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Requests.AddSymptomReportRelationRequest;
import cancer.cssbackend.Entities.SymptomReportRelation;
import cancer.cssbackend.Repositories.SymptomReportRelationRepository;
import cancer.cssbackend.Services.SymptomReportRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/symptom/report")
public class SymptomReportRelationController {
    private final SymptomReportRelationService symptomReportRelationService;

    @PostMapping("/add")
    public SymptomReportRelation addSymptomReportRelation(@RequestBody AddSymptomReportRelationRequest addSymptomReportRelationRequest){
        return symptomReportRelationService.addSymptomReportRelation(addSymptomReportRelationRequest);
    }
}
