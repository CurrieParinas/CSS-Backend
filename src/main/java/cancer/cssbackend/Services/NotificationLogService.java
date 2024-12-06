package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.NotificationLog;
import cancer.cssbackend.Entities.NotificationStatus;
import cancer.cssbackend.Repositories.NotificationLogRepository;
import cancer.cssbackend.Repositories.NotificationStatusRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationLogService {
    private final NotificationLogRepository notificationLogRepository;
    private final NotificationStatusRepository notificationStatusRepository;

    public int countUnreadByPatient(Long userID){
        return notificationLogRepository.countUnreadByUser(userID);
    }

    public String updateReadStatus(Long notifLogID){
        NotificationLog notificationLog = notificationLogRepository.findById(notifLogID)
                .orElseThrow(() -> new EntityNotFoundException("NotificationLog with ID " + notifLogID + " not found."));

        NotificationStatus notificationStatus = notificationStatusRepository.findByNotifStatusName("Read");

        notificationLog.setNotificationStatus(notificationStatus);
        notificationLog.setNotificationUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));
        notificationLogRepository.save(notificationLog);
        return "Successfully updated Read status.";
    }

    public List<NotificationLog> fetchUnreadByPatient(Long userID){
        List<NotificationLog> notifs = notificationLogRepository.fetchUnreadByUser(userID);

        if (notifs == null) {
            throw new IllegalStateException("No unread notifications found for user with ID: " + userID);
        } else {
            return notifs;
        }
    }
    public List<NotificationLog> fetchAllNotifsByPatient(Long userID){
        List<NotificationLog> notifs = notificationLogRepository.fetchAllNotifsByUser(userID);

        if (notifs == null) {
            throw new IllegalStateException("No notifications found for user with ID: " + userID);
        } else {
            return notifs;
        }
    }
}
