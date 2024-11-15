package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.NotificationLog;
import cancer.cssbackend.Entities.NotificationStatus;
import cancer.cssbackend.Repositories.NotificationLogRepository;
import cancer.cssbackend.Repositories.NotificationStatusRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationLogService {
    private final NotificationLogRepository notificationLogRepository;
    private final NotificationStatusRepository notificationStatusRepository;

    public int countUnreadByPatient(Long patientID){
        return notificationLogRepository.countUnreadByPatient(patientID);
    }

    public String updateReadStatus(Long notifLogID){
        NotificationLog notificationLog = notificationLogRepository.findById(notifLogID)
                .orElseThrow(() -> new EntityNotFoundException("NotificationLog with ID " + notifLogID + " not found."));

        NotificationStatus notificationStatus = notificationStatusRepository.findByNotifStatusName("Read");

        notificationLog.setNotificationStatus(notificationStatus);
        notificationLogRepository.save(notificationLog);
        return "Successfully updated Read status.";
    }
}
