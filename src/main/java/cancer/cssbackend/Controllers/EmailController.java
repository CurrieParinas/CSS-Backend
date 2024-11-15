package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.Requests.AddDoctorRequest;
import cancer.cssbackend.Entities.Requests.SendMessageRequest;
import cancer.cssbackend.Services.EmailService;
import cancer.cssbackend.Services.NotificationLogService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/email")
public class EmailController {
    private final EmailService emailService;
    private final NotificationLogService notificationLogService;
    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody SendMessageRequest sendMessageRequest) {
        try {
            emailService.sendEmail(sendMessageRequest);
            return ResponseEntity.ok("Email sent successfully!");
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to send email: " + e.getMessage());
        }
    }

    @GetMapping("/unread/count")
    public int countUnreadByPatient(@RequestParam(value="patientID") Long patientID){
        return notificationLogService.countUnreadByPatient(patientID);
    }
}
