package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Services.DoctorService;
import cancer.cssbackend.Services.HospitalService;
import cancer.cssbackend.Services.PatientService;
import cancer.cssbackend.Services.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddSurgeryRequest {

    @JsonProperty("PATIENT_ID")
    private Long patientId;

    @JsonProperty("SURGERY_OPERATION")
    private String surgeryOperation;

    @JsonProperty("SURGERY_DATE")
    private String surgeryDate;

    @JsonProperty("SURGERY_FINDINGS")
    private String surgeryFindings;

    @JsonProperty("SURGERY_INTENT")
    private String surgeryIntent; // Choices: Curative-complete, Curative-incomplete, Palliative only, Others

    @JsonProperty("SURGERY_SURGEON")
    private Long surgerySurgeon; // FK to Doctor

    @JsonProperty("SURGERY_HOSPITAL")
    private Long surgeryHospital; // FK to Hospital

    @JsonProperty("RXTYPE_ENCODER")
    private Long encoderId; // FK to User

    @JsonProperty("SURGERY_CREATEDON")
    private String createdOn; // System time

    @JsonProperty("SURGERY_UPDATEDON")
    private String updatedOn;

    public Surgery mapToSurgery(PatientService patientService, DoctorService doctorService, HospitalService hospitalService, UserService userService) {
        Surgery surgery = new Surgery();

        Patient patient = patientService.findPatient(patientId);
        if(patient != null){
            surgery.setPatient(patient);
        }


        surgery.setSurgeryOperation(this.surgeryOperation);
        surgery.setSurgeryDate(Date.valueOf(this.surgeryDate));
        surgery.setSurgeryFindings(this.surgeryFindings);
        surgery.setSurgeryIntent(this.surgeryIntent);


        Doctor doctor = doctorService.findDoctor(surgerySurgeon);
        if(doctor != null){
            surgery.setSurgerySurgeon(doctor);
        }
        Hospital hospital = hospitalService.findHospital(surgeryHospital);
        if(hospital != null){
            surgery.setSurgeryHospital(hospital);
        }
        User user = userService.getUser(encoderId);
        if(user != null){
            surgery.setEncoder(user);
        }

        surgery.setCreatedOn(Timestamp.valueOf(this.createdOn));
        surgery.setUpdatedOn(Timestamp.valueOf(this.updatedOn));
        return surgery;
    }
}