package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Chemotherapy;
import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.Hormonal;
import cancer.cssbackend.Entities.Hospital;
import cancer.cssbackend.Entities.Requests.AddChemotherapyRequest;
import cancer.cssbackend.Entities.Requests.AddHormonalRequest;
import cancer.cssbackend.Services.HormonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/hormonal")
public class HormonalController {
    private final HormonalService hormonalService;

    @PostMapping("/add")
    public Hormonal addHormonal(@RequestBody AddHormonalRequest addHormonalRequest) {
        return hormonalService.addHormonal(addHormonalRequest);
    }

    @GetMapping("/findalldoctors")
    public List<Doctor> fetchAllHormonalDoctors(){
        return hormonalService.fetchAllHormonalDoctors();
    }

    @GetMapping("/hospitals")
    public List<Hospital> fetchHormonalHospitals(){
        return hormonalService.fetchHormonalHospitals();
    }

    @GetMapping("/findbypatient")
    public List<Hormonal> findByPatient(@RequestParam(value="patientID") Long patientID){
        return hormonalService.findByPatientID(patientID);
    }
}
