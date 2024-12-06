package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.Requests.AddDoctorRequest;
import cancer.cssbackend.Services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;
import java.io.IOException;
import java.util.List;

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

    @GetMapping("/all")
    public List<Doctor> fetchAllDoctors(){
        return doctorService.fetchAllDoctors();
    }

    @GetMapping("/findbyhospital")
    public List<Doctor> fetchDoctorsByHospital(@RequestParam(value="hospitalID") Long hospitalID){
        return doctorService.findByHospital(hospitalID);
    }

    @GetMapping("/findallsurgeons")
    public List<Doctor> fetchAllSurgeons(){
        return doctorService.findAllSurgeons();
    }

    @GetMapping("/findsurgeonsbyhospital")
    public List<Doctor> findSurgeonsbyHospital(@RequestParam(value="hospitalID") Long hospitalID){
        return doctorService.findSurgeonByHospital(hospitalID);
    }

    @GetMapping("/finddoctorsbypatient")
    public List<Doctor> fetchDoctorsOfAPatient(@RequestParam(value="patientID") Long patientID){
        return doctorService.fetchDoctorsOfAPatient(patientID);
    }
}
