package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Entity(name = "IMMUNOTHERAPY")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Immunotherapy {
    @Id
    @GeneratedValue(generator = "IMMUNOTHERAPY_SEQ")
    @SequenceGenerator(name="IMMUNOTHERAPY_SEQ", sequenceName = "IMMUNOTHERAPY_SEQ", allocationSize = 1)
    @Column(name = "IMMUNORX_ID")
    private Long immunorxId;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID")
    private Patient patient;

    @Column(name = "IMMUNORX_DRUG")
    private String immunorxDrug;

    @Column(name = "IMMUNORX_INITIALDATE")
    private Date immunorxInitialdate;

    @Column(name = "IMMUNORX_ENDDATE")
    private Date immunorxEnddate;

    @Column(name = "IMMUNORX_STATUS")
    private String immunorxStatus;

    @Column(name = "IMMUNORX_NOTES")
    private String immunorxNotes;

    @Column(name = "IMMUNORX_ISCOMPLETED")
    private char immunorxIscompleted;

    @ManyToOne
    @JoinColumn(name = "IMMUNORX_FACILITY", referencedColumnName = "HOSPITAL_ID")
    private Hospital immunorxFacility;

    @ManyToOne
    @JoinColumn(name = "IMMUNORX_DOCTOR", referencedColumnName = "DOCTOR_ID")
    private Doctor immunorxDoctor;

    @ManyToOne
    @JoinColumn(name = "IMMUNORX_ENCODER", referencedColumnName = "USER_ID")
    private User immunorxEncoder;

    @Column(name = "IMMUNORX_CREATEDON")
    private Timestamp immunorxCreatedon;

    @Column(name = "IMMUNORX_UPDATEDON")
    private Timestamp immunorxUpdatedon;
}
