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
    public Patient addPatient(@RequestBody AddPatientRequest addPatientRequest) throws MessagingException {
        return patientService.addPatient(addPatientRequest);
    }

    @PutMapping("/update/{patientId}")
    public Patient updatePatient(@RequestBody AddPatientRequest addPatientRequest, @PathVariable Long patientId) {
        return patientService.updatePatient(addPatientRequest, patientId);
    }

    @GetMapping("/find")
    public Patient findPatientById(@RequestParam(value="patientID") Long patientID){
        return this.patientService.findPatient(patientID);
    }

    @DeleteMapping("/delete")
    public String deletePatientById(@RequestParam(value="patientID") Long patientID){
        return this.patientService.deletePatient(patientID);
    }

    @GetMapping("/getConsultInfo/{patientId}")
    public Map<String, Object> getConsultInfo(@PathVariable Long patientId){
        return patientService.getConsultInfo(patientId);
    }

    @GetMapping("/get/latest")
    public Patient fetchLatestCreated(@RequestParam(value="doctorID") Long doctorID){
        return this.patientService.fetchLatestCreatedPatient(doctorID);
    }
}
