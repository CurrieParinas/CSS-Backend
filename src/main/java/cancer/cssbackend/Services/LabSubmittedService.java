package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Entities.Requests.AddLabSubmittedRequest;
import cancer.cssbackend.Repositories.*;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LabSubmittedService {
    private final LabSubmittedRepository labSubmittedRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final WorkupRepository workupRepository;
    private final LabMonitorRepository labMonitorRepository;
    private final JavaMailSender javaMailSender;
    private final ResourceLoader resourceLoader;
    private final NotificationLogRepository notificationLogRepository;
    private final NotificationStatusRepository notificationStatusRepository;
    private final NotificationTypeRepository notificationTypeRepository;
    private final UserRepository userRepository;
    public LabSubmitted addLabSubmtited(AddLabSubmittedRequest addLabSubmittedRequest, MultipartFile labFileLocation) throws IOException, MessagingException {
        LabSubmitted labSubmitted = addLabSubmittedRequest.mapToLabSubmitted(patientRepository, doctorRepository, workupRepository);
        labSubmitted.setLabFileLocation(labFileLocation.getBytes());
        labSubmittedRepository.save(labSubmitted);
        LabMonitor labMonitor = new LabMonitor();
        labMonitor.setLabSubmitted(labSubmitted);
        LocalDateTime endDateTime = labSubmitted.getLabSubmissionDate().toLocalDateTime().plusMonths(labSubmitted.getWorkupName().getWorkupDuration());
        Date endDate = Date.valueOf(endDateTime.toLocalDate());
        labMonitor.setEndDate(endDate);
        labMonitorRepository.save(labMonitor);

        //send email
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        // Build the HTML content with the specified structure
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<!DOCTYPE html>");
        htmlContent.append("<html lang=\"en\">");
        htmlContent.append("<head>");
        htmlContent.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        htmlContent.append("<title>Password Reset Request</title>");
        htmlContent.append("<style>");
        htmlContent.append("body { font-family: 'Tahoma', sans-serif; margin: 0; padding: 20px; background-color: #e9ecef; }");
        htmlContent.append(".background { width: 90%; padding: 40px; background-color: #ffffff; }");
        htmlContent.append(".container { border: 1px solid #a1a1aa; max-width: 600px; margin: auto; background: #ffffff; padding: 40px; border-radius: 12px; box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15); text-align: center; border-top: 8px solid #742a2a; }");
        htmlContent.append("h1 { color: #333; font-size: 28px; margin-bottom: 15px; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }");
        htmlContent.append("p { color: #555; line-height: 1.8; font-size: 16px; margin: 10px 0; }");
        htmlContent.append("a { display: inline-block; margin: 30px 0; padding: 14px 30px; background: linear-gradient(90deg, #742a2a, #703535); color: #ffffff; text-decoration: none; border-radius: 30px; transition: background 0.3s ease, transform 0.3s ease; font-size: 18px; }");
        htmlContent.append("a:hover { background: linear-gradient(90deg, #4a1b1b, #542828); transform: scale(1.05); transition: background 1s ease, transform 1s ease; }");
        htmlContent.append(".footer { margin-top: 30px; font-size: 14px; color: #777; line-height: 1.6; }");
        htmlContent.append(".divider { margin: 30px 0; border-top: 1px solid #eaeaea; }");
        htmlContent.append(".note { font-size: 14px; color: #888; margin-top: 15px; }");
        htmlContent.append("</style>");
        htmlContent.append("</head>");
        htmlContent.append("<body>");
        htmlContent.append("<div class=\"container\">");
        htmlContent.append("<h1>From: <span style=\"color: white;\">")
                .append("cancersurveillancesystem@gmail.com")
                .append("</span></h1>");
        // Split the message into sentences and wrap each in <p> tags
        //look for patient name

        String messageBodyReal = labSubmitted.getPatient().getUser().getUserFirstname() + labSubmitted.getPatient().getUser().getUserMiddlename() + labSubmitted.getPatient().getUser().getUserLastname() + "has submitted their lab results.";
        String[] sentences = messageBodyReal.split("\\. ");
        for (String sentence : sentences) {
            htmlContent.append("<p>").append(sentence.trim()).append(".</p>");
        }

        htmlContent.append("<div class=\"footer\">");
        htmlContent.append("<p class=\"note\">This is an automated message. Please do not reply.</p>");
        htmlContent.append("</div>");
        htmlContent.append("</div>");
        htmlContent.append("</body>");
        htmlContent.append("</html>");

        // Set email properties
        helper.setTo(labSubmitted.getDoctor().getUser().getUserEmail());
        helper.setFrom("cancersurveillancesystem@gmail.com");
        helper.setSubject("Notice - Patient Lab Submission");
        helper.setText(htmlContent.toString(), true); // Set HTML content

        // Create and save the notification log
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setNotificationDate(Date.valueOf(LocalDate.now()));

        User reciever = userRepository.findById((long) labSubmitted.getDoctor().getUser().getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Receiver Error. No user found with ID: " + labSubmitted.getDoctor().getUser().getUserId()));
        notificationLog.setNotificationReceiver(reciever);

        User sender = userRepository.findById((long) 0)
                .orElseThrow(() -> new IllegalArgumentException("Sender error. No user found with ID: " + 0));
        notificationLog.setNotificationSender(sender);

        notificationLog.setNotificationNotes(messageBodyReal);
        notificationLog.setNotificationUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));

        NotificationType notificationType = notificationTypeRepository.findById((long) 2)
                .orElseThrow(() -> new IllegalArgumentException("No notification type found with ID: " + 2));
        notificationLog.setNotificationType(notificationType);

        // Set default notification status
        NotificationStatus notificationStatus = notificationStatusRepository.findByNotifStatusName("Unread");
        notificationLog.setNotificationStatus(notificationStatus);

        notificationLogRepository.save(notificationLog);

        // Send the email
        javaMailSender.send(message);

        return labSubmitted;
    }

    public List<LabSubmitted> getAllSubmissions() {
        return labSubmittedRepository.findAll();
    }
}
