package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.CheckupSchedule;
import cancer.cssbackend.Entities.Requests.AddCheckupScheduleRequest;
import cancer.cssbackend.Repositories.*;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Check;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public CheckupSchedule editConfirmedDate(Long checkupSchedulID, String date){
        Optional<CheckupSchedule> checkupSchedule = checkupScheduleRepository.findById(checkupSchedulID);

        if(checkupSchedule.isPresent()){
            checkupSchedule.get().setCheckupConfirmedDate(Date.valueOf(date));
            checkupSchedule.get().setCheckupUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));
            return checkupSchedule.get();
        } else {
            throw new RuntimeException("No Checkup Schedule with ID: " + checkupSchedulID);
        }
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
