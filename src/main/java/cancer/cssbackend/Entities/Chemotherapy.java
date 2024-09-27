package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Entity(name = "CHEMOTHERAPY")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Chemotherapy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CHEMOTHERAPY_SEQ")
    @SequenceGenerator(name = "CHEMOTHERAPY_SEQ", sequenceName = "CHEMOTHERAPY_SEQ", allocationSize = 1)
    @Column(name = "CHEMO_ID", nullable = false)
    private Long chemoId;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID")
    private Patient patient;

    @Column(name = "CHEMO_TYPE", nullable = false)
    private String chemoType; // Choices: neoadjuvant, adjuvant, palliative

    @ManyToOne
    @JoinColumn(name = "CHEMO_PROTOCOL", referencedColumnName = "CHEMOPROTOCOL_ID")
    private Chemoprotocol chemoProtocol;

    @Column(name = "CHEMO_INITIALDATE", nullable = false)
    private Date chemoInitialDate;

    @Column(name = "CHEMO_ENDDATE")
    private Date chemoEndDate;

    @Column(name = "CHEMO_CYCLENUMBERGIVEN")
    private int chemoCycleNumberGiven;

    @Column(name = "CHEMO_STATUS", nullable = false)
    private String chemoStatus; // Choices: ongoing, completed, not completed

    @Column(name = "CHEMO_NOTES")
    private String chemoNotes;

    @Column(name = "CHEMO_ISCOMPLETED")
    private char chemoIsCompleted;

    @ManyToOne
    @JoinColumn(name = "CHEMO_FACILITY", referencedColumnName = "HOSPITAL_ID")
    private Hospital chemoFacility;

    @ManyToOne
    @JoinColumn(name = "CHEMO_DOCTOR", referencedColumnName = "DOCTOR_ID")
    private Doctor chemoDoctor;

    @ManyToOne
    @JoinColumn(name = "CHEMO_ENCODER", referencedColumnName = "USER_ID")
    private User encoder;

    @Column(name = "CHEMO_CREATEDON")
    private Timestamp createdOn;

    @Column(name = "CHEMO_UPDATEDON")
    private Timestamp updatedOn;
}
