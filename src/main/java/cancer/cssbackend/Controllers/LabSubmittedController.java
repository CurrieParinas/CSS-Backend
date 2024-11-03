package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.LabSubmittedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/lab/submit")
public class LabSubmittedController {
    private final LabSubmittedService labSubmittedService;
}
