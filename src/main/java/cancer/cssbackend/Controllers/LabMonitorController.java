package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.LabMonitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/lab/monitor")
public class LabMonitorController {
    private final LabMonitorService labMonitorService;
}
