package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Onboard;
import cancer.cssbackend.Services.OnboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/onboard")

public class OnboardController {
    private final OnboardService onboardService;

    @GetMapping("/getPatientsByDoctor/{doctorId}")
    public List<Onboard> getPatientsByDoctor(@PathVariable Long doctorId) {
        return onboardService.getPatientsByDoctor(doctorId);
    }
}
