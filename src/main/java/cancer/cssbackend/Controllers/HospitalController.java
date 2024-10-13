package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Department;
import cancer.cssbackend.Entities.Hospital;
import cancer.cssbackend.Services.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/hospital")
public class HospitalController {
    private final HospitalService hospitalService;

    @GetMapping("/all")
    public List<Hospital> getAllHospitals(){
        return hospitalService.fetchAllHospitals();
    }
}
