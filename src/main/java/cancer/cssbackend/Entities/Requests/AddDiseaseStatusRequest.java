package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.Access;
import cancer.cssbackend.Entities.DiseaseStatus;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.User;
import cancer.cssbackend.Repositories.PatientRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

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
    }
}
