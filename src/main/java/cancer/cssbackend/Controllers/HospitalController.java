package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/hospital")
public class HospitalController {
    private final HospitalService hospitalService;
}
