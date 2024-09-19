package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.User;
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

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddDiseaseStatusRequest {
    @JsonProperty("PATIENT_ID")
    private Long patientID;

    @JsonProperty("HISTO_PATHOLOGY")
    private Long histoPathology;

    @JsonProperty("HISTO_TUMORSIZE")
    private int histoTumorSize;

    @JsonProperty("HISTO_TUMOREXTENSION")
    private char histoTumorExtension;

    @JsonProperty("HISTO_GRADE")
    private int histoGrade;

    @JsonProperty("HISTO_NODEPOSITIVE")
    private int histoNodePositive;

    @JsonProperty("HISTO_NODEHARVEST")
    private int histoNodeHarvest;

    @JsonProperty("HISTO_MARGINS_NEGATIVE")
    private char histoMarginsNegative;

    @JsonProperty("HISTO_POSITIVEMARGINS")
    private String histoMarginsPositive;

    @JsonProperty("HISTO_STAGE")
    private String histoStage;

    @JsonProperty("HISTO_CREATEDON")
    private Timestamp histoCreatedOn;

    @JsonProperty("HISTO_UPDATEDON")
    private Timestamp histoUpdatedOn;

    @JsonProperty("HISTO_ENCODER")
    private Long histoEncoderID;
}
