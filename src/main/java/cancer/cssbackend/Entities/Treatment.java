package cancer.cssbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Entity(name = "TREATMENT")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Treatment {
    @Id
    @GeneratedValue(generator = "TREATMENT_SEQ")
    @SequenceGenerator(name="TREATMENT_SEQ", sequenceName = "TREATMENT_SEQ", allocationSize = 1)
    @Column(name = "TREATMENT_ID", nullable = false)
    private Long treatmentId;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @Column(name = "TREATMENT_PRIMARYRXTYPE", nullable = false)
    private String treatmentPrimaryRxType;

    @Column(name = "TREATMENT_PRIMARYRXNAME", nullable = false)
    private String treatmentPrimaryRxName;

    @Column(name = "TREATMENT_INITIALRXDATE", nullable = false)
    private Date treatmentInitialRxDate;

    @Column(name = "TREATMENT_PURPOSE", nullable = false)
    private String treatmentPurpose; // Choices: Curative-complete, Curative-incomplete, Palliative only, Others

    @ManyToOne
    @JoinColumn(name = "TREATMENT_PLAN", nullable = false)
    private RXType treatmentPlan; // Foreign key to RXTYPE

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TREATMENT_ENCODER")
    private User encoder; // Foreign key to USER table

    @Column(name = "TREATMENT_CREATEDON")
    private Timestamp createdOn; // System time now

    @Column(name = "TREATMENT_UPDATEDON")
    private Timestamp updatedOn;
}
