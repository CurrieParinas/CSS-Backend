package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Entities.Requests.AddChemotherapyRequest;
import cancer.cssbackend.Entities.Requests.AddImmunotherapyRequest;
import cancer.cssbackend.Services.ImmunotherapyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/immunotherapy")
public class ImmunotherapyController {
    private final ImmunotherapyService immunotherapyService;

    @PostMapping("/add")
    public Immunotherapy addImmunotherapy(@RequestBody AddImmunotherapyRequest addImmunotherapyRequest) {
        return immunotherapyService.addImmunotherapy(addImmunotherapyRequest);
    }

    @GetMapping("/fetchalldoctors")
    public List<Doctor> fetchAllDoctors(){
        return immunotherapyService.fetchAllDoctors();
    }

    @GetMapping("/fetchdoctorsbyfacility")
    public List<Doctor> fetchDoctorsByFacility(@RequestParam("facilityID") Long facilityID){
        return immunotherapyService.fetchDoctorsByFacility(facilityID);
    }

    @GetMapping("/facilities")
    public List<Hospital> fetchImmunotherapyFacilities(){
        return immunotherapyService.fetchImmunotherapyFacilities();
    }

    @GetMapping("/findbypatient")
    public List<Immunotherapy> findByPatient(@RequestParam(value="patientID") Long patientID){
        return immunotherapyService.findByPatientID(patientID);
    }

    @GetMapping("/findbypatient/latest")
    public Immunotherapy findLatestByPatient(@RequestParam(value="patientID") Long patientID){
        return immunotherapyService.fetchLatestByPatient(patientID);
    }

    @PostMapping("/updatecompletedstatus")
    public Immunotherapy updateIsCompleted(@RequestParam(value="immunotherapyID") Long immunotherapyID, @RequestParam(value="completed") char completed){
        return immunotherapyService.updateIsCompleted(immunotherapyID, completed);
    }
}
