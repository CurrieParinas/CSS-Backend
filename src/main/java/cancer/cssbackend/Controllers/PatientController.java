package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Requests.AddPatientRequest;
import cancer.cssbackend.Services.PatientService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/patient")
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/add")
    public Patient addPatient(@RequestBody AddPatientRequest addPatientRequest) throws MessagingException, IOException {
        return patientService.addPatient(addPatientRequest);
    }

    @GetMapping("/find")
    public Patient findPatientById(@RequestParam(value="patientID") Long patientID){
        return this.patientService.findPatient(patientID);
    }

    @DeleteMapping("/delete")
    public String deletePatientById(@RequestParam(value="patientID") Long patientID){
        return this.patientService.deletePatient(patientID);
    }

    @GetMapping("/getADOCRH/{patientId}")
    public Map<String, Object> getADOCRH(@PathVariable Long patientId){
        return patientService.getADOCRH(patientId);
    }
}
