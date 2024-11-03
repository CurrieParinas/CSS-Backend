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
import java.time.LocalDateTime;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddDiseaseStatusRequest {
    @JsonProperty("PATIENT_ID")
    private Long patientID;

    @JsonProperty("DXSTATUS_ALIVE")
    private char dxstatusAlive;

    @JsonProperty("DXSTATUS_SYMPTOMS")
    private char dxstatusSymptoms;

    @JsonProperty("DXSTATUS_RECURRENCE")
    private char dxstatusRecurrence;

    @JsonProperty("DXSTATUS_METASTATIC")
    private char dxstatussMetastatic;

    @JsonProperty("DXSTATUS_CURATIVE")
    private char dxstatusCurative;

    public DiseaseStatus mapToDiseaseStatus(){
        DiseaseStatus diseaseStatus = new DiseaseStatus();

        diseaseStatus.setDxstatusAlive(dxstatusAlive);
        diseaseStatus.setDxstatusSymptoms(dxstatusSymptoms);
        diseaseStatus.setDxstatusRecurrence(dxstatusRecurrence);
        diseaseStatus.setDxstatusMetastatic(dxstatussMetastatic);
        diseaseStatus.setDxstatusCurative(dxstatusCurative);
        diseaseStatus.setDxstatusCreatedOn(Timestamp.valueOf(LocalDateTime.now()));

        return diseaseStatus;
    }
}
