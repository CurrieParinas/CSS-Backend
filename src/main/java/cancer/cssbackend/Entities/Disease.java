package cancer.cssbackend.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.Meta;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "DISEASE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Disease {
    @Id
    @JsonProperty("DISEASE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "DISEASE_SEQ")
    @SequenceGenerator(name = "DISEASE_SEQ", sequenceName = "DISEASE_SEQ", allocationSize = 1)
    @Column(name = "DISEASE_ID", nullable = false)
    private Long diseaseID;

    @OneToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID")
    @JsonProperty("PATIENT_ID")
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "DISEASE_PRIMARY_SITE", referencedColumnName = "BODYSITE_ID")
    @JsonProperty("DISEASE_PRIMARY_SITE")
    private BodySite bodySite;

    @Column(name = "DISEASE_DIAGNOSISDATE")
    private Date diseaseDiagnosisDate;

    @OneToOne
    @JoinColumn(name = "DISEASE_BASIS", referencedColumnName = "BASIS_ID")
    @JsonProperty("DISEASE_BASIS")
    private Basis basis;

    @Column(name = "DISEASE_LATERALITY")
    private String diseaseLaterality;

    //wala pa histology table
    //@Column(name = "DISEASE_HISTOLOGY")
    //private int diseaseHistology;

    @Column(name = "DISEASE_EXTENT")
    private String diseaseExtent;

    @Column(name = "DISEASE_TUMORSIZE")
    private int diseaseTumorSize;

    @Column(name = "DISEASE_LYMPHNODE")
    private int diseaseLymphNode;

    @Column(name = "DISEASE_METASTATIC")
    private char diseaseMetastatic;

    @OneToMany
    @JoinColumn(name = "DISEASE_METASTATICSITE")
    @JsonProperty("DISEASE_METASTATICSITE")
    private List<MetastaticSite> metastaticSites;

    @Column(name = "DISEASE_MULTIPLEPRIMARY")
    private int diseaseMultiplePrimary;

    @OneToMany
    @JoinColumn(name = "DISEASE_OTHERSITE")
    @JsonProperty("DISEASE_OTHERSITE")
    private List<MetastaticSite> otherSites;

    @Column(name = "DISEASE_TSTAGE")
    private int diseaseTstage;

    @Column(name = "DISEASE_NSTAGE")
    private int diseaseNstage;

    @Column(name = "DISEASE_MSTAGE")
    private int diseaseMstage;

    @Column(name = "DISEASE_GSTAGE")
    private int diseaseGstage;

    @Column(name = "DISEASE_STAGE")
    private String diseaseStage;

    @Column(name = "DISEASE_STAGETYPE")
    private String diseaseStageType;

    @OneToMany
    @JoinColumn(name = "DISEASE_STATUS")
    @JsonProperty("DISEASE_STATUS")
    private List<DiseaseStatus> diseaseStatuses;

    @Column(name = "DISEASE_CREATEDON")
    private Timestamp diseaseCreatedOn;

    @Column(name = "DISEASE_UPDATEDON")
    private Timestamp diseaseUpdatedOn;

    @ManyToOne
    @JoinColumn(name = "DISEASE_ENCODER", referencedColumnName = "USER_ID")
    @JsonProperty("DISEASE_ENCODER")
    private User diseaseEncoder;


}