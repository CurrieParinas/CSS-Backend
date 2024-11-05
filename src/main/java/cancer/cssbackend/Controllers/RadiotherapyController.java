package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Entities.Requests.AddChemotherapyRequest;
import cancer.cssbackend.Entities.Requests.AddRadiotherapyRequest;
import cancer.cssbackend.Services.RadiotherapyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/radiotherapy")
public class RadiotherapyController {
    private final RadiotherapyService radiotherapyService;

    @PostMapping("/add")
    public Radiotherapy addRadiotherapy(@RequestBody AddRadiotherapyRequest addRadiotherapyRequest) {
        return radiotherapyService.addRadiotherapy(addRadiotherapyRequest);
    }

    @GetMapping("/findalldoctors")
    public List<Doctor> fetchAllRadiotherapyDoctors(){
        return radiotherapyService.fetchAllRadiotherapyDoctors();
    }

    @GetMapping("/finddoctorsbyfacility")
    public List<Doctor> findDoctorsByFacility(@RequestParam(value="facilityID") Long facilityID){
        return radiotherapyService.fetchRadiotherapyDoctorsByFacility(facilityID);
    }

    @GetMapping("/facilities")
    public List<Hospital> fetchRadiotherapyFacilities(){
        return radiotherapyService.fetchRadiotherapyFacilities();
    }

    @GetMapping("/findbypatient")
    public List<Radiotherapy> findByPatient(@RequestParam(value="patientID") Long patientID){
        return radiotherapyService.findByPatientID(patientID);
    }

    @GetMapping("/findbypatient/latest")
    public Radiotherapy findLatestByPatient(@RequestParam(value="patientID") Long patientID){
        return radiotherapyService.fetchLatestByPatient(patientID);
    }
}
