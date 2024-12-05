package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.CheckupSchedule;
import cancer.cssbackend.Entities.Requests.AddCheckupScheduleRequest;
import cancer.cssbackend.Repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<CheckupSchedule> fetchAllByDoctor(Long doctorID){
        return checkupScheduleRepository.fetchAllByDoctor(doctorID);
    }

    public List<CheckupSchedule> fetchAllByDoctorAndDate(Long doctorID, String date){
        return checkupScheduleRepository.fetchAllByDoctorAndDate(doctorID, date);
    }

    public List<CheckupSchedule> fetchAllByPatient(Long patientID){
        return checkupScheduleRepository.fetchAllByPatient(patientID);
    }

    public List<CheckupSchedule> fetchAllByPatientAndDate(Long patientID, String date){
        return checkupScheduleRepository.fetchAllByPatientAndDate(patientID, date);
    }
}
