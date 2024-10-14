package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "HISTOLOGY")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Histology {
    @Id
    @SequenceGenerator(name = "HISTOLOGY_SEQ", sequenceName = "HISTOLOGY_SEQ", allocationSize = 1)
    @Column(name = "HISTOLOGY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "HISTOLOGY_SEQ")
    private Long histologyId;

    @OneToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="HISTO_PATHOLOGY")
    private PathologyDim histoPathology;

    @Column(name = "HISTO_TUMOR_SIZE")
    private int histoTumorSize;

    @Column(name = "HISTO_TUMOR_EXTENSION")
    private char histoTumorExtension;

    @Column(name = "HISTO_GRADE")
    private int histoGrade;

    @Column(name = "HISTO_NODE_POSITIVE")
    private int histoNodePositive;

    @Column(name = "HISTO_NODE_HARVEST")
    private int histoNodeHarvest;

    @Column(name = "HISTO_MARGINS_NEGATIVE")
    private char histoMarginsNegative;

    @Column(name = "HISTO_POSITIVE_MARGINS")
    private String histoMarginsPositive;

    @Column(name = "HISTO_STAGE")
    private String histoStage;

    @Column(name = "HISTO_CREATED_ON")
    private Timestamp histoCreatedOn;

    @Column(name = "HISTO_UPDATED_ON")
    private Timestamp histoUpdatedOn;

    @ManyToOne
    @JoinColumn(name = "HISTO_ENCODER", referencedColumnName = "DOCTOR_ID")
    private Doctor histoEncoder;
}
