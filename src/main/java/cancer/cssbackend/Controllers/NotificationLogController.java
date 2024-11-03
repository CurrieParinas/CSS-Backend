package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.NotificationLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/notif/log")
public class NotificationLogController {
    private final NotificationLogService notificationLogService;
}
