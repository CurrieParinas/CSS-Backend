package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Requests.AddDoctorRequest;
import cancer.cssbackend.Entities.Requests.AddPatientRequest;
import cancer.cssbackend.Services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;
import java.io.IOException;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/doctor"})
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping("/add")
    public Doctor addDoctor(@RequestPart("addDoctorRequest") AddDoctorRequest addDoctorRequest,
                            @RequestPart("doctorESig") MultipartFile doctorESignature) throws IOException {
        return doctorService.addDoctor(addDoctorRequest, doctorESignature);
    }
}
