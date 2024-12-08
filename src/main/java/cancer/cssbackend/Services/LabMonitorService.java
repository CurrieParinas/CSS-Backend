package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.LabMonitor;
import cancer.cssbackend.Repositories.LabMonitorRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LabMonitorService {
    private final LabMonitorRepository labMonitorRepository;
    private final EmailService emailService;

    @Scheduled(fixedRate = 1000 * 60 * 60 * 24) // Check daily
    public void processSchedules() throws MessagingException, IOException {
        // Fetch ongoing schedules
        List<LabMonitor> ongoingMonitoring = labMonitorRepository.findByStatus("ONGOING");

        for (LabMonitor monitor : ongoingMonitoring) {
            LocalDate today = LocalDate.now();

            // Calculate months since the start date
            long monthsSinceStart = ChronoUnit.MONTHS.between(monitor.getLabSubmitted().getLabSubmissionDate().toLocalDateTime().toLocalDate(), today);

            // Check if it's time to send an email
            if (monthsSinceStart % monitor.getLabSubmitted().getWorkupName().getWorkupFrequency() == 0 && monitor.getLabSubmitted().getLabSubmissionDate().toLocalDateTime().toLocalDate() != today) {
                emailService.sendLabEmail('r', monitor.getLabSubmitted().getPatient().getUser().getUserEmail(), "Lab Submission Reminder", monitor.getLabSubmitted().getPatient().getUser().getUserLastname(), monitor.getLabSubmitted().getDoctor().getUser().getUserLastname(), monitor.getLabSubmitted().getWorkupName().getCancerType().getBodysiteName(), monitor.getLabSubmitted().getWorkupName().getWorkupName());

                // Check if the current date is equal to or after the end date
                if (!today.isBefore(monitor.getEndDate().toLocalDate())) { // today >= endDate
                    monitor.setStatus("COMPLETED");
                }

                // Save updated schedule
                labMonitorRepository.save(monitor);
            }
        }
    }
}
