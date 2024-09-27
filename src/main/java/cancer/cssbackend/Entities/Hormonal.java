package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Entity(name = "HORMONAL")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Hormonal {
    @Id
    @GeneratedValue(generator = "HORMONAL_SEQ")
    @SequenceGenerator(name="HORMONAL_SEQ", sequenceName = "HORMONAL_SEQ", allocationSize = 1)
    @Column(name = "HORMONAL_ID")
    private Long hormonalId;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID")
    private Patient patient;

    @Column(name = "HORMONAL_DRUG")
    private String hormonalDrug;

    @Column(name = "HORMONAL_DOSE")
    private int hormonalDose;

    @Column(name = "HORMONAL_INITIALDATE")
    private Date hormonalInitialdate;

    @Column(name = "HORMONAL_ENDDATE")
    private Date hormonalEnddate;

    @Column(name = "HORMONAL_STATUS")
    private String hormonalStatus;

    @Column(name = "HORMONAL_RX_NOTES")
    private String hormonalRxNotes;

    @ManyToOne
    @JoinColumn(name = "HORMONAL_DOCTOR", referencedColumnName = "DOCTOR_ID")
    private Doctor hormonalDoctor;

    @ManyToOne
    @JoinColumn(name = "HORMONAL_ENCODER", referencedColumnName = "USER_ID")
    private User hormonalEncoder;

    @Column(name = "HORMONAL_CREATEDON")
    private Timestamp hormonalCreatedon;

    @Column(name = "HORMONAL_UPDATEDON")
    private Timestamp hormonalUpdatedon;
}
