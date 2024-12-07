package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.SurveyResponse;
import cancer.cssbackend.Entities.SymptomSurvey;
import cancer.cssbackend.Repositories.DoctorRepository;
import cancer.cssbackend.Repositories.PatientRepository;
import cancer.cssbackend.Repositories.SymptomSurveyRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.Optional;

public class AddSurveyResponseRequest {
    @JsonProperty("patient_id")
    public Long patientId;

    @JsonProperty("doctor_id")
    public Long doctorId;

    @JsonProperty("survey_response_date")
    public String surveyResponseDate;

    @JsonProperty("response_note")
    public String responseNote;

    public SurveyResponse mapToSurveyResponse(PatientRepository patientRepository, DoctorRepository doctorRepository, SymptomSurveyRepository symptomSurveyRepository){
        SurveyResponse surveyResponse = new SurveyResponse();

        Optional<Patient> patient = patientRepository.findById(patientId);
        if(patient.isPresent()){
            surveyResponse.setPatient(patient.get());
        } else{
            throw new RuntimeException("Patient not found with ID " + patientId);
        }

        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if(doctor.isPresent()){
            surveyResponse.setDoctor(doctor.get());
        } else{
            throw new RuntimeException("Doctor not found with ID " + doctorId);
        }

        surveyResponse.setSurveyResponseDate(Timestamp.valueOf(this.surveyResponseDate));

        surveyResponse.setResponseNote(this.responseNote);

        return surveyResponse;
    }
}
