package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.CheckupStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/checkup/status")
public class CheckupStatusController {
    private final CheckupStatusService checkupStatusService;
}
