package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.CheckupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/checkup")
public class CheckupController {
    private final CheckupService checkupService;
}
