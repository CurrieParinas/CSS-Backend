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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LabSubmittedService {
    private final LabSubmittedRepository labSubmittedRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final WorkupRepository workupRepository;
    private final LabMonitorRepository labMonitorRepository;
    private final NotificationLogRepository notificationLogRepository;
    private final NotificationStatusRepository notificationStatusRepository;
    private final NotificationTypeRepository notificationTypeRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;

    public LabSubmitted addLabSubmtited(AddLabSubmittedRequest addLabSubmittedRequest, MultipartFile labFileLocation) throws IOException, MessagingException {
        LabSubmitted labSubmitted = addLabSubmittedRequest.mapToLabSubmitted(patientRepository, doctorRepository, workupRepository);
        labSubmitted.setLabFileLocation(labFileLocation.getBytes());
        labSubmittedRepository.save(labSubmitted);
        LabMonitor labMonitor = new LabMonitor();
        labMonitor.setLabSubmitted(labSubmitted);
        LocalDateTime endDateTime = labSubmitted.getLabSubmissionDate().toLocalDateTime().plusMonths(labSubmitted.getWorkupName().getWorkupDuration());
        Date endDate = Date.valueOf(endDateTime.toLocalDate());
        labMonitor.setEndDate(endDate);
        labMonitor.setStatus("ONGOING");
        labMonitor.setEmailStatus("SENT");
        labMonitorRepository.save(labMonitor);

        // Create and save the notification log
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setNotificationDate(Date.valueOf(LocalDate.now()));

        User reciever = userRepository.findById((long) labSubmitted.getDoctor().getUser().getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Receiver Error. No user found with ID: " + labSubmitted.getDoctor().getUser().getUserId()));
        notificationLog.setNotificationReceiver(reciever);

        User sender = userRepository.findById((long) 0)
                .orElseThrow(() -> new IllegalArgumentException("Sender error. No user found with ID: " + 0));
        notificationLog.setNotificationSender(sender);

        notificationLog.setNotificationNotes(labSubmitted.getPatient().getUser().getUserFirstname() + " " + labSubmitted.getPatient().getUser().getUserLastname() + "has submitted their lab results.");
        notificationLog.setNotificationUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));

        NotificationType notificationType = notificationTypeRepository.findById((long) 2)
                .orElseThrow(() -> new IllegalArgumentException("No notification type found with ID: " + 2));
        notificationLog.setNotificationType(notificationType);

        // Set default notification status
        NotificationStatus notificationStatus = notificationStatusRepository.findByNotifStatusName("Unread");
        notificationLog.setNotificationStatus(notificationStatus);

        notificationLogRepository.save(notificationLog);

        emailService.sendLabEmail('n', labSubmitted.getPatient().getUser().getUserEmail(), "Notice - Patient Lab Submission", labSubmitted.getPatient().getUser().getUserFirstname() + " " + labSubmitted.getPatient().getUser().getUserLastname(), labSubmitted.getDoctor().getUser().getUserFirstname() + " " + labSubmitted.getDoctor().getUser().getUserLastname(), labSubmitted.getWorkupName().getCancerType().getBodysiteName(), labSubmitted.getWorkupName().getWorkupName());

        return labSubmitted;
    }

    public LabSubmitted addLabSubmittedNoMonitoring(AddLabSubmittedRequest addLabSubmittedRequest, MultipartFile labFileLocation) throws IOException, MessagingException {
        LabSubmitted labSubmitted = addLabSubmittedRequest.mapToLabSubmitted(patientRepository, doctorRepository, workupRepository);
        labSubmitted.setLabFileLocation(labFileLocation.getBytes());
        labSubmittedRepository.save(labSubmitted);

        // Create and save the notification log
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setNotificationDate(Date.valueOf(LocalDate.now()));

        User reciever = userRepository.findById((long) labSubmitted.getDoctor().getUser().getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Receiver Error. No user found with ID: " + labSubmitted.getDoctor().getUser().getUserId()));
        notificationLog.setNotificationReceiver(reciever);

        User sender = userRepository.findById((long) 0)
                .orElseThrow(() -> new IllegalArgumentException("Sender error. No user found with ID: " + 0));
        notificationLog.setNotificationSender(sender);

        notificationLog.setNotificationNotes(labSubmitted.getPatient().getUser().getUserFirstname() + " " + labSubmitted.getPatient().getUser().getUserLastname() + "has submitted their lab results.");
        notificationLog.setNotificationUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));

        NotificationType notificationType = notificationTypeRepository.findById((long) 2)
                .orElseThrow(() -> new IllegalArgumentException("No notification type found with ID: " + 2));
        notificationLog.setNotificationType(notificationType);

        // Set default notification status
        NotificationStatus notificationStatus = notificationStatusRepository.findByNotifStatusName("Unread");
        notificationLog.setNotificationStatus(notificationStatus);

        notificationLogRepository.save(notificationLog);

        emailService.sendLabEmail('n', labSubmitted.getPatient().getUser().getUserEmail(), "Notice - Patient Lab Submission", labSubmitted.getPatient().getUser().getUserFirstname() + " " + labSubmitted.getPatient().getUser().getUserLastname(), labSubmitted.getDoctor().getUser().getUserFirstname() + " " + labSubmitted.getDoctor().getUser().getUserLastname(), labSubmitted.getWorkupName().getCancerType().getBodysiteName(), labSubmitted.getWorkupName().getWorkupName());

        return labSubmitted;
    }

    public List<LabSubmitted> getAllSubmissions() {
        return labSubmittedRepository.findAll();
    }

    public List<LabSubmitted> getSubmissionByDoctor(Long doctorId) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            return labSubmittedRepository.findByDoctor(doctor);
        }
        return null;
    }
}
