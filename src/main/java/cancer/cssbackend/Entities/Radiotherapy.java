package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Entity(name = "RADIOTHERAPY")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Radiotherapy {
    @Id
    @GeneratedValue(generator = "RADIOTHERAPY_SEQ")
    @SequenceGenerator(name="RADIOTHERAPY_SEQ", sequenceName = "RADIOTHERAPY_SEQ", allocationSize = 1)
    @Column(name = "RADRX_ID", nullable = false)
    private Long radRxId;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "RADRX_TYPE", nullable = false)
    private RadDetails radRxType; // Foreign key to RAD_DETAILS table

    @Column(name = "RADRX_INITIALDATE", nullable = false)
    private Date radRxInitialDate;

    @Column(name = "RADRX_LASTDATE")
    private Date radRxLastDate;

    @Column(name = "RADRX_DOSE", nullable = false)
    private int radRxDose;

    @Column(name = "RADRX_BODYSITE", nullable = false)
    private String radRxBodySite;

    @Column(name = "RADRX_STATUS", nullable = false)
    private String radRxStatus; // Choices: ongoing, completed, not completed

    @Column(name = "RADRX_ISCOMPLETED", nullable = false)
    private char radRxIsCompleted; // 'Y' or 'N'

    @ManyToOne
    @JoinColumn(name = "RADRX_FACILITY")
    private Hospital radRxFacility;

    @ManyToOne
    @JoinColumn(name = "RADRX_DOCTOR", nullable = false)
    private Doctor radRxDoctor;

    @ManyToOne
    @JoinColumn(name = "RADRX_ENCODER")
    private User encoder;

    @Column(name = "RADRX_CREATEDON")
    private Timestamp createdOn;

    @Column(name = "RADRX_UPDATEDON")
    private Timestamp updatedOn;
}
