package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.NotificationLogService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/notif/log")
public class NotificationLogController {
    private final NotificationLogService notificationLogService;

    @PutMapping("/{notifLogID}/status/read")
    public ResponseEntity<String> markNotificationAsRead(@PathVariable Long notifLogID) {
        try {
            String message = notificationLogService.updateReadStatus(notifLogID);
            return ResponseEntity.ok(message);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while updating the notification status.");
        }
    }

}
