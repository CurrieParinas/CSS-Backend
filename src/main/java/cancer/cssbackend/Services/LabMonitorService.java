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

    @Scheduled(cron = "0 0 8-16/2 * * *") // Every 2 hours from 8 AM to 4 PM
    public void processSchedulesSendToday() throws MessagingException {
        // Fetch ongoing schedules
        List<LabMonitor> ongoingMonitoring = labMonitorRepository.findByStatus("ONGOING");

        for (LabMonitor monitor : ongoingMonitoring) {
            LocalDate today = LocalDate.now();

            // Calculate months since the start date
            long monthsSinceStart = ChronoUnit.MONTHS.between(monitor.getLabSubmitted().getLabSubmissionDate().toLocalDateTime().toLocalDate(), today);

            // Check if the email should be sent today
            if (monthsSinceStart % monitor.getLabSubmitted().getWorkupName().getWorkupFrequency() == 0 && monitor.getEmailStatus().equals("SEND")) {
                emailService.sendLabEmail('r', monitor.getLabSubmitted().getPatient().getUser().getUserEmail(), "Lab Submission Reminder", monitor.getLabSubmitted().getPatient().getUser().getUserFirstname() + " " + monitor.getLabSubmitted().getPatient().getUser().getUserLastname(), monitor.getLabSubmitted().getDoctor().getUser().getUserFirstname() + " " + monitor.getLabSubmitted().getDoctor().getUser().getUserLastname(), monitor.getLabSubmitted().getWorkupName().getCancerType().getBodysiteName(), monitor.getLabSubmitted().getWorkupName().getWorkupName());
                monitor.setEmailStatus("SENT");

                // Check if the current date is equal to or after the end date
                if (!today.isBefore(monitor.getEndDate().toLocalDate())) { // today >= endDate
                    monitor.setStatus("COMPLETED");
                }

                labMonitorRepository.save(monitor);
            }
        }
    }

    @Scheduled(cron = "0 0 17-23/2 * * *") // Every 2 hours from 5 PM to 11 PM
    public void processSchedulesSendTomorrow() throws MessagingException {
        // Fetch ongoing schedules
        List<LabMonitor> ongoingMonitoring = labMonitorRepository.findByStatus("ONGOING");

        for (LabMonitor monitor : ongoingMonitoring) {
            LocalDate today = LocalDate.now();

            // Calculate months since the start date
            long monthsSinceStartTomorrow = ChronoUnit.MONTHS.between(monitor.getLabSubmitted().getLabSubmissionDate().toLocalDateTime().toLocalDate().plusDays(1), today);

            //Check if the email should be sent tomorrow
            if (monthsSinceStartTomorrow % monitor.getLabSubmitted().getWorkupName().getWorkupFrequency() == 0 && !monitor.getEmailStatus().equals("SEND")) {
                monitor.setEmailStatus("SEND");
                labMonitorRepository.save(monitor);
            }
        }
    }
}
