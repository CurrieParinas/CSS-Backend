package cancer.cssbackend.Entities.Requests;
import cancer.cssbackend.Entities.DiseaseStatus;
import cancer.cssbackend.Repositories.PatientRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddDiseaseStatusRequest {
    private final PatientRepository patientRepository;

    @JsonProperty("PATIENT_ID")
    private Long patientID;

    @JsonProperty("DXSTATUS_ALIVE")
    private char dxstatusAlive;

    @JsonProperty("DXSTATUS_SYMPTOMS")
    private char dxstatusSymptoms;
    //@JsonProperty("PATIENT_ID")
    //private Long patientID;

    //@JsonProperty("HISTO_PATHOLOGY")
    //private Long histoPathology;

    @JsonProperty("DXSTATUS_ALIVE")
    private char diseaseStatusAlive;

    @JsonProperty("DXSTATUS_SYMPTOMS")
    private char diseaseStatusSymptoms;

    @JsonProperty("DXSTATUS_RECURRENCE")
    private char diseaseStatusRecurrence;

    @JsonProperty("DXSTATUS_METASTATIC")
    private char diseaseStatusMetastatic;

    @JsonProperty("DXSTATUS_CURATIVE")
    private char diseaseStatusCurative;

    @JsonProperty("DXSTATUS_CREATEDON")
    private String diseaseStatusCreatedOn;

    /*
    @JsonProperty("HISTO_TUMORSIZE")
    private int histoTumorSize;
>>>>>>> Stashed changes

    @JsonProperty("DXSTATUS_RECURRENCE")
    private char dxstatusRecurrence;

    @JsonProperty("DXSTATUS_METASTATIC")
    private char dxstatusMetastatic;

    @JsonProperty("DXSTATUS_CURATIVE")
    private char dxstatusCurative;

    @JsonProperty("DXSTATUS_CREATED_ON")
    private Timestamp dxstatusCreatedOn;

    public DiseaseStatus mapToDiseaseStatus(){
        DiseaseStatus diseaseStatus = new DiseaseStatus();
        Optional<Patient> optionalPatient = patientRepository.findById(this.patientID);

        if(optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            diseaseStatus.setPatient(patient);
            diseaseStatus.setDxstatusAlive(this.dxstatusAlive);
            diseaseStatus.setDxstatusSymptoms(this.dxstatusSymptoms);
            diseaseStatus.setDxstatusRecurrence(this.dxstatusRecurrence);
            diseaseStatus.setDxstatusMetastatic(this.dxstatusMetastatic);
            diseaseStatus.setDxstatusCurative(this.dxstatusCurative);

            Timestamp currrentTimestamp = Timestamp.valueOf(LocalDateTime.now());
            diseaseStatus.setDxstatusCreatedOn(currrentTimestamp);
            return diseaseStatus;
        }
        return null;
    @JsonProperty("HISTO_STAGE")
    private String histoStage;

    @JsonProperty("HISTO_CREATEDON")
    private String histoCreatedOn;

    @JsonProperty("HISTO_UPDATEDON")
    private String histoUpdatedOn;

    @JsonProperty("HISTO_ENCODER")
    private Long histoEncoderID;
    */
    public DiseaseStatus mapToDiseaseStatus(){
        DiseaseStatus diseaseStatus = new DiseaseStatus();

        diseaseStatus.setDiseaseStatusAlive(this.diseaseStatusAlive);
        diseaseStatus.setDiseaseStatusSymptoms(this.diseaseStatusSymptoms);
        diseaseStatus.setDiseaseStatusRecurrence(this.diseaseStatusRecurrence);
        diseaseStatus.setDiseaseStatusMetastatic(this.diseaseStatusMetastatic);
        diseaseStatus.setDiseaseStatusCurative(this.diseaseStatusCurative);
        diseaseStatus.setDiseaseStatusCreatedOn(Timestamp.valueOf(this.diseaseStatusCreatedOn));

        return diseaseStatus;
    }
}
