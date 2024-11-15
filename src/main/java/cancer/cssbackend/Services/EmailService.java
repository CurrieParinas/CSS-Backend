package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Entities.Requests.SendMessageRequest;
import cancer.cssbackend.Repositories.*;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final ResourceLoader resourceLoader;

    private final NotificationLogRepository notificationLogRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final NotificationStatusRepository notificationStatusRepository;
    private final NotificationTypeRepository notificationTypeRepository;

    public void sendHtmlEmail(String type, String to, String subject, Long userId, String token) throws MessagingException, IOException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(to);
        helper.setSubject(subject);

        String htmlBody = "";
        if (type.equals("verification")) {
            htmlBody = loadHtmlTemplate("classpath:verification_email.html");
        } else if (type.equals("forgot")) {
            htmlBody = loadHtmlTemplate("classpath:forgot_password.html");
        }
        htmlBody = htmlBody.replace("${userId}", userId.toString());
        htmlBody = htmlBody.replace("${token}", token);

        helper.setText(htmlBody, true);

        javaMailSender.send(message);
    }

    public void sendTempPassEmail(String to, String subject, Long userId, String token, String temporaryPassword) throws MessagingException, IOException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(to);
        helper.setSubject(subject);
        String htmlBody = loadHtmlTemplate("classpath:temporary_password.html");
        htmlBody = htmlBody.replace("${userId}", userId.toString());
        htmlBody = htmlBody.replace("${token}", token);
        htmlBody = htmlBody.replace("${temporaryPassword}", temporaryPassword);

        helper.setText(htmlBody, true);

        javaMailSender.send(message);
    }

    private String loadHtmlTemplate(String path) throws IOException {
        Resource resource = resourceLoader.getResource(path);
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return contentBuilder.toString();
    }

    public NotificationLog sendEmail(SendMessageRequest sendMessageRequest) throws MessagingException, IOException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        String finalMessage = "From: " + sendMessageRequest.getSenderEmail() + "\n" + sendMessageRequest.getMessage();

        helper.setTo(sendMessageRequest.getReceieverEmail());
        helper.setFrom(sendMessageRequest.getSenderEmail());
        helper.setSubject(sendMessageRequest.getSubject());
        helper.setText(finalMessage);


        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setNotificationDate(Date.valueOf(LocalDate.now()));

        Patient patient = patientRepository.findById((long) sendMessageRequest.getRecieverID())
                .orElseThrow(() -> new IllegalArgumentException("No patient found with ID: " + sendMessageRequest.getRecieverID()));
        notificationLog.setNotificationReceiver(patient);

        Doctor doctor = doctorRepository.findById((long) sendMessageRequest.getSenderID())
                .orElseThrow(() -> new IllegalArgumentException("No doctor found with ID: " + sendMessageRequest.getSenderID()));
        notificationLog.setNotificationSender(doctor);

        notificationLog.setNotificationNotes(sendMessageRequest.getMessage());
        notificationLog.setNotificationUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));

        NotificationType notificationType = notificationTypeRepository.findById((long) sendMessageRequest.getNotifType())
                .orElseThrow(() -> new IllegalArgumentException("No notification type found with ID: " + sendMessageRequest.getNotifType()));
        notificationLog.setNotificationType(notificationType);

        //naka set to default na
        NotificationStatus notificationStatus = notificationStatusRepository.findByNotifStatusName("Unread");
        notificationLog.setNotificationStatus(notificationStatus);

        notificationLogRepository.save(notificationLog);
        javaMailSender.send(message);
        return notificationLog;
    }
}
