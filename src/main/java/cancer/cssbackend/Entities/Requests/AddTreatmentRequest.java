package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.RXType;
import cancer.cssbackend.Entities.Treatment;
import cancer.cssbackend.Entities.User;
import cancer.cssbackend.Services.PatientService;
import cancer.cssbackend.Services.RxTypeService;
import cancer.cssbackend.Services.TreatmentService;
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
public class AddTreatmentRequest {
    @JsonProperty("PATIENT_ID")
    private Long patientId;

    @JsonProperty("TREATMENT_PRIMARYRXTYPE")
    private String treatmentPrimaryRxType;

    @JsonProperty("TREATMENT_PRIMARYRXNAME")
    private String treatmentPrimaryRxName;

    @JsonProperty("TREATMENT_INITIALRXDATE")
    private String treatmentInitialRxDate;

    @JsonProperty("TREATMENT_PURPOSE")
    private String treatmentPurpose; // Choices: Curative-complete, Curative-incomplete, Palliative only, Others

    @JsonProperty("TREATMENT_PLAN")
    private Long treatmentPlan; // Foreign key to RXTYPE

    @JsonProperty("TREATMENT_ENCODER")
    private Long encoder; // Foreign key to USER table

    @JsonProperty("TREATMENT_CREATEDON")
    private String createdOn; // System time now

    @JsonProperty("TREATMENT_UPDATEDON")
    private String updatedOn;

    // Method to map to Treatment entity
    public Treatment mapToTreatment(PatientService patientService, RxTypeService rxTypeService, UserService userService) {
        Treatment treatment = new Treatment();
        Patient patient = patientService.findPatient(patientId);
        if(patient != null){
            treatment.setPatient(patient);
        }
        treatment.setTreatmentPrimaryRxType(treatmentPrimaryRxType);
        treatment.setTreatmentPrimaryRxName(treatmentPrimaryRxName);
        treatment.setTreatmentInitialRxDate(Date.valueOf(this.treatmentInitialRxDate));
        treatment.setTreatmentPurpose(treatmentPurpose);

        RXType rxtype = rxTypeService.findRXType(treatmentPlan);
        if(rxtype != null){
            treatment.setTreatmentPlan(rxtype);
        }
        User user = userService.getUser(encoder);
        if(user != null){
            treatment.setEncoder(user);
        }

        treatment.setCreatedOn(Timestamp.valueOf(this.createdOn));
        treatment.setUpdatedOn(Timestamp.valueOf(this.updatedOn));
        return treatment;
    }
}
