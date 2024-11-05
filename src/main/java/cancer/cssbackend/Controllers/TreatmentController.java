package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Chemotherapy;
import cancer.cssbackend.Entities.Requests.AddTreatmentRequest;
import cancer.cssbackend.Entities.Treatment;
import cancer.cssbackend.Services.TreatmentService;
import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/findbypatient")
    public List<Treatment> findByPatient(@RequestParam(value="patientID") Long patientID){
        return treatmentService.findByPatientID(patientID);
    }

    @GetMapping("/findbypatient/latest")
    public Treatment findLatestByPatient(@RequestParam(value="patientID") Long patientID){
        return treatmentService.fetchLatestByPatient(patientID);
    }
}
