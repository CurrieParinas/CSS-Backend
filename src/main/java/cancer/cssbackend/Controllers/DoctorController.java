package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Requests.AddDoctorRequest;
import cancer.cssbackend.Entities.Requests.AddPatientRequest;
import cancer.cssbackend.Services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/doctor"})
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping("/add")
    public Doctor addDoctor(@RequestBody AddDoctorRequest addDoctorRequest) {
        return doctorService.addDoctor(addDoctorRequest);
    }
}
