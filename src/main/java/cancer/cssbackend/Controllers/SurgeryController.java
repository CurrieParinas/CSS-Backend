package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Chemotherapy;
import cancer.cssbackend.Entities.Hospital;
import cancer.cssbackend.Entities.Requests.AddChemotherapyRequest;
import cancer.cssbackend.Entities.Requests.AddSurgeryRequest;
import cancer.cssbackend.Entities.Surgery;
import cancer.cssbackend.Entities.Treatment;
import cancer.cssbackend.Services.SurgeryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/surgery")
public class SurgeryController {
    private final SurgeryService surgeryService;
    @PostMapping("/add")
    public Surgery addSurgery(@RequestBody AddSurgeryRequest addSurgeryRequest) {
        return surgeryService.addSurgery(addSurgeryRequest);
    }

    @GetMapping("/hospitals")
    public List<Hospital> fetchSurgeryHospitals(){
        return surgeryService.fetchSurgeryHospitals();
    }

    @GetMapping("/findbypatient")
    public List<Surgery> findByPatient(@RequestParam(value="patientID") Long patientID){
        return surgeryService.findByPatientID(patientID);
    }

    @GetMapping("/findbypatient/latest")
    public Surgery findLatestByPatient(@RequestParam(value="patientID") Long patientID){
        return surgeryService.fetchLatestByPatient(patientID);
    }
}
