package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Hospital;
import cancer.cssbackend.Entities.Specialty;
import cancer.cssbackend.Services.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/specialty")
public class SpecialtyController {
    private final SpecialtyService specialtyService;

    @GetMapping("/all")
    public List<Specialty> getAllSpecialties(){
        return specialtyService.fetchAllSpecialties();
    }
}
