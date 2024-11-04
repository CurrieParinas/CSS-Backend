package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Entity(name = "SURGERY")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Surgery {
    @Id
    @SequenceGenerator(name = "SURGERY_SEQ", sequenceName = "SURGERY_SEQ", allocationSize = 1)
    @Column(name = "SURGERY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SURGERY_SEQ")
    private Long surgeryId;

    @OneToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID")
    private Patient patient;

    @Column(name = "SURGERY_OPERATION", nullable = false)
    private String surgeryOperation;

    @Column(name = "SURGERY_DATE", nullable = false)
    private Date surgeryDate;

    @Column(name = "SURGERY_FINDINGS", nullable = false)
    private String surgeryFindings;

    @Column(name = "SURGERY_INTENT")
    private String surgeryIntent; // Choices: Curative-complete, Curative-incomplete, Palliative only, Others

    @ManyToOne
    @JoinColumn(name = "SURGERY_SURGEON")
    private Doctor surgerySurgeon;

    @ManyToOne
    @JoinColumn(name = "SURGERY_HOSPITAL")
    private Hospital surgeryHospital;

    @ManyToOne
    @JoinColumn(name = "SURGERY_ENCODER")
    private User encoder;

    @Column(name = "SURGERY_CREATEDON")
    private Timestamp createdOn; // System time

    @Column(name = "SURGERY_UPDATEDON")
    private Timestamp updatedOn;
}
