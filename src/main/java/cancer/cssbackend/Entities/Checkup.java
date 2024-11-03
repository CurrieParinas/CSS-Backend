package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "CHECKUP")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Checkup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CHECKUP_SEQ")
    @SequenceGenerator(name = "CHECKUP_SEQ", sequenceName = "CHECKUP_SEQ", allocationSize = 1)
    @Column(name = "CHECKUP_ID", nullable = false)
    private Long checkupID;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    private Patient patientId;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor doctor;

    @Column(name = "CHECKUP_DATE")
    private Timestamp checkupDate;

    @Column(name = "CHECKUP_SUBJECTIVE", nullable = false, length = 1000)
    private String checkupSubjective;

    @Column(name = "CHECKUP_OBJECTIVE", nullable = false, length = 1000)
    private String checkupObjective;

    @Column(name = "CHECKUP_ASSESSMENT", nullable = false, length = 1000)
    private String checkupAssessment;

    @Column(name = "CHECKUP_PLAN", nullable = false, length = 1000)
    private String checkupPlan;

    @Column(name = "CHECKUP_SURVWORKUP", nullable = false, length = 1000)
    private String checkupSurvWorkup;

    @ManyToOne
    @JoinColumn(name = "CHECKUP_PATIENTSTATUS")
    private DiseaseStatus checkupPatientStatus;

    @ManyToOne
    @JoinColumn(name = "CHECKUP_SCHEDULE")
    private CheckupSchedule checkupSchedule;
}
