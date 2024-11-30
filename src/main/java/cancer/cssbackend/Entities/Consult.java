package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Entity(name = "CONSULT")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Consult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CONSULT_SEQ")
    @SequenceGenerator(name = "CONSULT_SEQ", sequenceName = "CONSULT_SEQ", allocationSize = 1)
    @Column(name = "CONSULT_ID", nullable = false)
    private Long consultId;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID")
    private Patient patient;

    @Column(name = "CONSULT_DATE")
    private Date consultDate;

    @Column(name = "CONSULT_SUBJECTIVE", nullable = false)
    private String consultSubjective;

    @Column(name = "CONSULT_OBJECTIVE", nullable = false)
    private String consultObjective;

    @Column(name = "CONSULT_SURVWORKUP", nullable = false)
    private String consultSurvworkup;

    @Column(name = "CONSULT_ASSESSMENT", nullable = false)
    private String consultAssessment;

    @Column(name = "CONSULT_RXPLAN", nullable = false)
    private String consultRxplan;

    @OneToOne
    @JoinColumn(name = "CONSULT_PATIENTSTATUS", referencedColumnName = "DXSTATUS_ID")
    private DiseaseStatus consultPatientstatus;
}
