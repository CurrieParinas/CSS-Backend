package cancer.cssbackend.Controllers;

import cancer.cssbackend.Entities.CheckupSchedule;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Requests.AddCheckupScheduleRequest;
import cancer.cssbackend.Entities.Requests.AddPatientRequest;
import cancer.cssbackend.Services.CheckupScheduleService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/checkup/schedule")
public class CheckupScheduleController {
    private final CheckupScheduleService checkupScheduleService;

    @PostMapping("/add")
    public CheckupSchedule addCheckupSchedule(@RequestBody AddCheckupScheduleRequest addCheckupScheduleRequest) throws IOException {
        return checkupScheduleService.addCheckupSchedule(addCheckupScheduleRequest);
    }
}
