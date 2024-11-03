package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.NotificationStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/notif/status")
public class NotificationStatusController {
    private final NotificationStatusService notificationStatusService;
}
