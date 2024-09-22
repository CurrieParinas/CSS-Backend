package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/doctor"})
public class DoctorController {
    private final DoctorService doctorService;
}
