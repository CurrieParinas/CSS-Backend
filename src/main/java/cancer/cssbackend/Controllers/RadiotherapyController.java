package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.RadiotherapyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/radiotherapy")
public class RadiotherapyController {
    private final RadiotherapyService radiotherapyService;
}
