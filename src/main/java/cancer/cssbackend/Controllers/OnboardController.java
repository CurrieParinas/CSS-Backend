package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.OnboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/onboard")

public class OnboardController {
    private final OnboardService onboardService;
}
