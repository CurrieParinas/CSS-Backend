package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/specialty")
public class SpecialtyController {
    private final SpecialtyService specialtyService;
}