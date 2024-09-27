package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.ImmunotherapyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/immunotherapy")
public class ImmunotherapyController {
    private final ImmunotherapyService immunotherapyService;
}
