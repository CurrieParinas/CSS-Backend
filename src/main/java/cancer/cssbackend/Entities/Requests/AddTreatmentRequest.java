package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Services.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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

    //RXTYPE FIELDS
    @JsonProperty("RXTYPE_SURGERY")
    private char rxtypeSurgery;

    @JsonProperty("RXTYPE_CHEMOTHERAPY")
    private char rxtypeChemotherapy;

    @JsonProperty("RXTYPE_RADIOTHERAPY")
    private char rxtypeRadiotherapy;

    @JsonProperty("RXTYPE_IMMUNOTHERAPY")
    private char rxtypeImmunotherapy;

    @JsonProperty("RXTYPE_HORMONALTHERAPY")
    private char rxtypeHormonalTherapy;

    @JsonProperty("RXTYPE_OTHERS")
    private char rxtypeOthers;

    @JsonProperty("RXTYPE_NOTES")
    private String rxtypeNotes;

    @JsonProperty("RXTYPE_ENCODER")
    private Long rxtypeEncoderId;
//
//    //SURGERY FIELDS
//    @JsonProperty("SURGERY_OPERATION")
//    private String surgeryOperation;
//
//    @JsonProperty("SURGERY_DATE")
//    private String surgeryDate;
//
//    @JsonProperty("SURGERY_FINDINGS")
//    private String surgeryFindings;
//
//    @JsonProperty("SURGERY_INTENT")
//    private String surgeryIntent; // Choices: Curative-complete, Curative-incomplete, Palliative only, Others
//
//    @JsonProperty("SURGERY_SURGEON")
//    private Long surgerySurgeon; // FK to Doctor
//
//    @JsonProperty("SURGERY_HOSPITAL")
//    private Long surgeryHospital; // FK to Hospital
//
//    @JsonProperty("SURGERY_ENCODER")
//    private Long surgeryEncoderId; // FK to User
//
//    @JsonProperty("SURGERY_CREATEDON")
//    private String surgeryCreatedOn; // System time
//
//    @JsonProperty("SURGERY_UPDATEDON")
//    private String surgeryUpdatedOn;
//
//    //RADIOTHERAPY FIELDS
//    @JsonProperty("RADRX_TYPE")
//    private Long radRxType;
//
//    @JsonProperty("RADRX_INITIALDATE")
//    private String radRxInitialDate;
//
//    @JsonProperty("RADRX_LASTDATE")
//    private String radRxLastDate;
//
//    @JsonProperty("RADRX_DOSE")
//    private int radRxDose;
//
//    @JsonProperty("RADRX_BODYSITE")
//    private String radRxBodySite;
//
//    @JsonProperty("RADRX_STATUS")
//    private String radRxStatus;
//
//    @JsonProperty("RADRX_ISCOMPLETED")
//    private char radRxIsCompleted; // 'Y' or 'N'
//
//    @JsonProperty("RADRX_FACILITY")
//    private Long radRxFacility;
//
//    @JsonProperty("RADRX_DOCTOR")
//    private Long radRxDoctor;
//
//    @JsonProperty("RADRX_ENCODER")
//    private Long radRxEncoder;
//
//    @JsonProperty("RADRX_CREATEDON")
//    private String radRxCreatedOn;
//
//    @JsonProperty("RADRX_UPDATEDON")
//    private String radRxUpdatedOn;
//
//    //HORMONAL FIELDS
//
//    @JsonProperty("hormonalDrug")
//    private String hormonalDrug;
//
//    @JsonProperty("hormonalDose")
//    private int hormonalDose;
//
//    @JsonProperty("hormonalInitialDate")
//    private String hormonalInitialdate;
//
//    @JsonProperty("hormonalEndDate")
//    private String hormonalEnddate;
//
//    @JsonProperty("hormonalStatus")
//    private String hormonalStatus;
//
//    @JsonProperty("hormonalRxNotes")
//    private String hormonalRxNotes;
//
//    @JsonProperty("hormonalDoctorId")
//    private Long hormonalDoctorId;
//
//    @JsonProperty("hormonalEncoderId")
//    private Long hormonalEncoderId;
//
//    @JsonProperty("hormonalCreatedOn")
//    private String hormonalCreatedon;
//
//    @JsonProperty("hormonalUpdatedOn")
//    private String hormonalUpdatedon;
//
//    //IMMUNOTHERAPY FIELDS
//    @JsonProperty("immunorxDrug")
//    private String immunorxDrug;
//
//    @JsonProperty("immunorxInitialDate")
//    private String immunorxInitialdate;
//
//    @JsonProperty("immunorxEndDate")
//    private String immunorxEnddate;
//
//    @JsonProperty("immunorxStatus")
//    private String immunorxStatus;
//
//    @JsonProperty("immunorxNotes")
//    private String immunorxNotes;
//
//    @JsonProperty("immunorxIsCompleted")
//    private char immunorxIscompleted;
//
//    @JsonProperty("immunorxFacilityId")
//    private Long immunorxFacilityId;
//
//    @JsonProperty("immunorxDoctorId")
//    private Long immunorxDoctorId;
//
//    @JsonProperty("immunorxEncoderId")
//    private Long immunorxEncoderId;
//
//    @JsonProperty("immunorxCreatedOn")
//    private String  immunorxCreatedon;
//
//    @JsonProperty("immunorxUpdatedOn")
//    private String immunorxUpdatedon;
//
//    //CHEMOTHERAPY FIELDS
//    @JsonProperty("CHEMO_TYPE")
//    private String chemoType; // Choices: neoadjuvant, adjuvant, palliative
//
//    @JsonProperty("CHEMO_PROTOCOL")
//    private Long chemoProtocolId;
//
//    @JsonProperty("CHEMO_INITIALDATE")
//    private String chemoInitialDate;
//
//    @JsonProperty("CHEMO_ENDDATE")
//    private String chemoEndDate;
//
//    @JsonProperty("CHEMO_CYCLENUMBERGIVEN")
//    private int chemoCycleNumberGiven;
//
//    @JsonProperty("CHEMO_STATUS")
//    private String chemoStatus; // Choices: ongoing, completed, not completed
//
//    @JsonProperty("CHEMO_NOTES")
//    private String chemoNotes;
//
//    @JsonProperty("CHEMO_ISCOMPLETED")
//    private char chemoIsCompleted;
//
//    @JsonProperty("CHEMO_FACILITY")
//    private Long chemoFacilityId;
//
//    @JsonProperty("CHEMO_DOCTOR")
//    private Long chemoDoctorId;
//
//    @JsonProperty("CHEMO_ENCODER")
//    private Long chemoEncoderId;
//
//    @JsonProperty("CHEMO_CREATEDON")
//    private String chemoCreatedOn; // System-generated, can be null in add requests
//
//    @JsonProperty("CHEMO_UPDATEDON")
//    private String chemoUpdatedOn; // Optional, usually set by system
    // Method to map to Treatment entity
    public Treatment mapToTreatment(PatientService patientService, RxTypeService rxTypeService,
                                    UserService userService) {
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
        } else{
            RXType rxType2 = new RXType();


            rxType2.setPatient(patient);
            rxType2.setRxtypeSurgery(this.rxtypeSurgery);
            rxType2.setRxtypeChemotherapy(this.rxtypeChemotherapy);
            rxType2.setRxtypeRadiotherapy(this.rxtypeRadiotherapy);
            rxType2.setRxtypeImmunotherapy(this.rxtypeImmunotherapy);
            rxType2.setRxtypeHormonalTherapy(this.rxtypeHormonalTherapy);
            rxType2.setRxtypeOthers(this.rxtypeOthers);
            rxType2.setRxtypeNotes(this.rxtypeNotes);

            User encoderUser = userService.getUser(rxtypeEncoderId);
            if(encoderUser != null){
                rxType2.setEncoder(encoderUser);
            }

            treatment.setTreatmentPlan(rxType2);
        }
        User user = userService.getUser(encoder);
        if(user != null){
            treatment.setEncoder(user);
        }

        treatment.setCreatedOn(Timestamp.valueOf(LocalDateTime.now()));
        treatment.setUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));

        return treatment;
    }
}
