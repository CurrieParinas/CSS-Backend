package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Disease;
import cancer.cssbackend.Entities.DiseaseOtherSite;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Requests.AddDiseaseRequest;
import cancer.cssbackend.Entities.Requests.AddPatientRequest;
import cancer.cssbackend.Services.DiseaseOtherSiteService;
import cancer.cssbackend.Services.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/disease")
public class DiseaseController {
    private final DiseaseService diseaseService;
    private final DiseaseOtherSiteService diseaseOtherSiteService;

    @PostMapping("/add")
    public Disease addDisease(@RequestBody AddDiseaseRequest addDiseaseRequest) {
        return diseaseService.addDisease(addDiseaseRequest);
    }

    @PutMapping("/update/{diseaseId}")
    public Disease updateDisease(@RequestBody AddDiseaseRequest addDiseaseRequest, @PathVariable Long diseaseId) {
        return diseaseService.updateDisease(addDiseaseRequest, diseaseId);
    }

    @GetMapping("/getbypatientid")
    public Disease findDiseaseByPatientID(@RequestParam(value="patientID") Long patientID){
        return diseaseService.findByPatientID(patientID);
    }

    @GetMapping("/othersites/get")
    public List<DiseaseOtherSite> fetchOthersites(@RequestParam(value="diseaseID") Long diseaseID){
        return diseaseOtherSiteService.fetchByDiseaseID(diseaseID);
    }
}
