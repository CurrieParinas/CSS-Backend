package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Entities.Requests.AddChemotherapyRequest;
import cancer.cssbackend.Entities.Requests.AddPatientRequest;
import cancer.cssbackend.Services.ChemotherapyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/chemotherapy")
public class ChemotherapyController {
    private final ChemotherapyService chemotherapyService;

    @PostMapping("/add")
    public Chemotherapy addChemotherapy(@RequestBody AddChemotherapyRequest addChemotherapyRequest) {
        return chemotherapyService.addChemotherapy(addChemotherapyRequest);
    }

    @GetMapping("/findalldoctors")
    public List<Doctor> fetchAllChemotherapyDoctors(){
        return chemotherapyService.fetchAllDoctors();
    }

    @GetMapping("/finddoctorsbyfacility")
    public List<Doctor> fetchDoctorsByFacility(@RequestParam(value="facilityID") Long facilityID){
        return chemotherapyService.fetchDoctorsByFacility(facilityID);
    }

    @GetMapping("/facilities")
    public List<Hospital> fetchChemotherapyFacilities(){
        return chemotherapyService.fetchChemotherapyFacilities();
    }

    @GetMapping("/findbypatient")
    public List<Chemotherapy> findByPatient(@RequestParam(value="patientID") Long patientID){
        return chemotherapyService.findByPatientID(patientID);
    }

    @GetMapping("/findbypatient/latest")
    public Chemotherapy findLatestByPatient(@RequestParam(value="patientID") Long patientID){
        return chemotherapyService.fetchLatestByPatient(patientID);
    }
}
