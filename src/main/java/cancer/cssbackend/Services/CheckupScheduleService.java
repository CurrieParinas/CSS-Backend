package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.CheckupSchedule;
import cancer.cssbackend.Entities.Requests.AddCheckupScheduleRequest;
import cancer.cssbackend.Repositories.CheckupScheduleRepository;
import cancer.cssbackend.Repositories.CheckupStatusRepository;
import cancer.cssbackend.Repositories.DoctorRepository;
import cancer.cssbackend.Repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckupScheduleService {
    private final CheckupScheduleRepository checkupScheduleRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final CheckupStatusRepository checkupStatusRepository;

    public CheckupSchedule addCheckupSchedule(AddCheckupScheduleRequest addCheckupScheduleRequest){
        CheckupSchedule checkupSchedule = addCheckupScheduleRequest.mapToCheckupSchedule(patientRepository, doctorRepository, checkupStatusRepository);
        checkupScheduleRepository.save(checkupSchedule);
        return checkupSchedule;
    }
}
