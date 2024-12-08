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
    private final NotificationStatusRepository notificationStatusRepository;
    private final NotificationTypeRepository notificationTypeRepository;
    private final UserRepository userRepository;

    public void sendHtmlEmail(char type, String to, String subject, Long userId, String token) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(to);
        helper.setSubject(subject);

        String htmlBody = "";
        if (type == 'v') {
            htmlBody = loadHtmlTemplate("classpath:verification_email.html");
        } else if (type == 'f') {
            htmlBody = loadHtmlTemplate("classpath:forgot_password.html");
        }

        htmlBody = htmlBody.replace("${userId}", userId.toString());
        htmlBody = htmlBody.replace("${token}", token);

        helper.setText(htmlBody, true);

        javaMailSender.send(message);
    }

    public void sendTempPassEmail(String to, String subject, Long userId, String token, String temporaryPassword) throws MessagingException {
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

    public void sendLabEmail(char type, String to, String subject, String patient, String doctor, String cancerType, String workup) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(to);
        helper.setSubject(subject);

        String htmlBody = "";
        if (type == 'n') {
            htmlBody = loadHtmlTemplate("classpath:lab_submit_notice.html");
        } else if (type == 'r') {
            htmlBody = loadHtmlTemplate("classpath:lab_submit_reminder.html");
        }

        htmlBody = htmlBody.replace("${patient}", patient);
        htmlBody = htmlBody.replace("${doctor}", doctor);
        htmlBody = htmlBody.replace("${cancerType}", cancerType);
        htmlBody = htmlBody.replace("${workup}", workup);

        helper.setText(htmlBody, true);

        javaMailSender.send(message);
    }

    private String loadHtmlTemplate(String path) {
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
                .append(sendMessageRequest.getSenderEmail())
                .append("</span></h1>");
        // Split the message into sentences and wrap each in <p> tags
        String[] sentences = sendMessageRequest.getMessage().split("\\. ");
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
        helper.setTo(sendMessageRequest.getReceieverEmail());
        helper.setFrom(sendMessageRequest.getSenderEmail());
        helper.setSubject(sendMessageRequest.getSubject());
        helper.setText(htmlContent.toString(), true); // Set HTML content

        // Create and save the notification log
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setNotificationDate(Date.valueOf(LocalDate.now()));

        User reciever = userRepository.findById((long) sendMessageRequest.getRecieverID())
                .orElseThrow(() -> new IllegalArgumentException("Receiver Error. No user found with ID: " + sendMessageRequest.getRecieverID()));
        notificationLog.setNotificationReceiver(reciever);

        User sender = userRepository.findById((long) sendMessageRequest.getSenderID())
                .orElseThrow(() -> new IllegalArgumentException("Sender error. No user found with ID: " + sendMessageRequest.getSenderID()));
        notificationLog.setNotificationSender(sender);

        notificationLog.setNotificationNotes(sendMessageRequest.getMessage());
        notificationLog.setNotificationUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));

        NotificationType notificationType = notificationTypeRepository.findById((long) sendMessageRequest.getNotifType())
                .orElseThrow(() -> new IllegalArgumentException("No notification type found with ID: " + sendMessageRequest.getNotifType()));
        notificationLog.setNotificationType(notificationType);

        // Set default notification status
        NotificationStatus notificationStatus = notificationStatusRepository.findByNotifStatusName("Unread");
        notificationLog.setNotificationStatus(notificationStatus);

        notificationLogRepository.save(notificationLog);

        // Send the email
        javaMailSender.send(message);
        return notificationLog;
    }
}
