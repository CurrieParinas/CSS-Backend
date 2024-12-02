package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.LabSubmitted;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.Workup;
import cancer.cssbackend.Repositories.DoctorRepository;
import cancer.cssbackend.Repositories.PatientRepository;
import cancer.cssbackend.Repositories.WorkupRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Optional;

public class AddLabSubmittedRequest {
    @JsonProperty("patient_id")
    public Long patientId;

    @JsonProperty("doctor_id")
    public Long doctorId;

    @JsonProperty("lab_submission_date")
    public String labSubmissionDate;

    @JsonProperty("workup_name_id")
    public Long workupNameId;

    public LabSubmitted mapToLabSubmitted(PatientRepository patientRepository, DoctorRepository doctorRepository, WorkupRepository workupRepository){
        LabSubmitted labSubmitted = new LabSubmitted();

        Optional<Patient> patient = patientRepository.findById(patientId);
        if(patient.isPresent()){
            labSubmitted.setPatient(patient.get());
        } else{
            throw new RuntimeException("Patient not found with ID " + patientId);
        }
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if(doctor.isPresent()){
            labSubmitted.setDoctor(doctor.get());
        } else{
            throw new RuntimeException("Doctor not found with ID " + doctorId);
        }

        labSubmitted.setLabSubmissionDate(Timestamp.valueOf(labSubmissionDate));

        Optional<Workup> workup = workupRepository.findById(workupNameId);
        if(workup.isPresent()){
            labSubmitted.setWorkupName(workup.get());
        } else {
            throw new RuntimeException("Workup not found with ID " + workupNameId);
        }

        return labSubmitted;
    }
}
