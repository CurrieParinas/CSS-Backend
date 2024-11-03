package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.NotificationStatusRepository;
import cancer.cssbackend.Repositories.NotificationTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationStatusService {
    private final NotificationStatusRepository notificationStatusRepository;
}
