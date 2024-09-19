package cancer.cssbackend.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "DISEASESTATUS")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DiseaseStatus {
    @Id
    @SequenceGenerator(name = "DISEASESTATUS_SEQ", sequenceName = "DISEASESTATUS_SEQ", allocationSize = 1)
    @Column(name = "DXSTATUS_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "DISEASESTATUS_SEQ")
    private Long diseaseStatusID;

    @OneToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID")
    @JsonProperty("PATIENT_ID")
    private Patient patient;

    @Column(name="HISTO_PATHOLOGY")
    private Long histoPathology;

    @Column(name = "HISTO_TUMORSIZE")
    private int histoTumorSize;

    @Column(name = "HISTO_TUMOREXTENSION")
    private char histoTumorExtension;

    @Column(name = "HISTO_GRADE")
    private int histoGrade;

    @Column(name = "HISTO_NODEPOSITIVE")
    private int histoNodePositive;

    @Column(name = "HISTO_NODEHARVEST")
    private int histoNodeHarvest;

    @Column(name = "HISTO_MARGINS_NEGATIVE")
    private char histoMarginsNegative;

    @Column(name = "HISTO_POSITIVEMARGINS")
    private String histoMarginsPositive;

    @Column(name = "HISTO_STAGE")
    private String histoStage;

    @Column(name = "HISTO_CREATEDON")
    private Timestamp histoCreatedOn;

    @Column(name = "HISTO_UPDATEDON")
    private Timestamp histoUpdatedOn;


    //tama ba to huhu
    @ManyToOne
    @JoinColumn(name = "HISTO_ENCODER", referencedColumnName = "HISTO_ENCODER")
    @JsonProperty("HISTO_ENCODER")
    private User histoEncoder;
}
