package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.CheckupSchedule;
import cancer.cssbackend.Entities.CheckupStatus;
import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Repositories.CheckupScheduleRepository;
import cancer.cssbackend.Repositories.CheckupStatusRepository;
import cancer.cssbackend.Repositories.DoctorRepository;
import cancer.cssbackend.Repositories.PatientRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Check;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class AddCheckupScheduleRequest {

    @JsonProperty("patient_id")
    public Long patientId;

    @JsonProperty("doctor_id")
    public Long doctorId;

    @JsonProperty("checkup_request_date")
    public String checkupRequestDate;

    @JsonProperty("checkup_confirmed_date")
    public String checkupConfirmedDate;

    @JsonProperty("checkup_start_time")
    public String checkupStartTime;

    @JsonProperty("checkup_end_time")
    public String checkupEndTime;

    @JsonProperty("checkup_status_id")
    public Long checkupStatusId;


    public CheckupSchedule mapToCheckupSchedule(PatientRepository patientRepository, DoctorRepository doctorRepository, CheckupStatusRepository checkupStatusRepository){
        CheckupSchedule checkupSchedule = new CheckupSchedule();

        Optional<Patient> patient = patientRepository.findById(patientId);
        if(patient.isPresent()){
            checkupSchedule.setPatient(patient.get());
        } else{
            throw new RuntimeException("Patient not found with ID " + patientId);
        }
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if(doctor.isPresent()){
            checkupSchedule.setDoctor(doctor.get());
        } else{
            throw new RuntimeException("Doctor not found with ID " + doctorId);
        }

        checkupSchedule.setCheckupRequestDate(Date.valueOf(this.checkupRequestDate));
        checkupSchedule.setCheckupConfirmedDate(Date.valueOf(this.checkupConfirmedDate));
        checkupSchedule.setCheckupStartTime(Timestamp.valueOf(this.checkupStartTime));
        checkupSchedule.setCheckupEndTime(Timestamp.valueOf(this.checkupEndTime));

        Optional<CheckupStatus> checkupStatus = checkupStatusRepository.findById(checkupStatusId);
        checkupStatus.ifPresent(checkupSchedule::setCheckupStatus);

        checkupSchedule.setCheckupUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));

        return checkupSchedule;
    }
}
