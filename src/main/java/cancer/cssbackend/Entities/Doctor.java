package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity(name = "DOCTOR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @SequenceGenerator(name = "DOCTOR_SEQ", sequenceName = "DOCTOR_SEQ", allocationSize = 1)
    @Column(name = "DOCTOR_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "DOCTOR_SEQ")
    private Long doctorID;

    //@OneToOne(mappedBy = user)
    //@Column(name = )
    //private Patient patient;

    @Column(name = "DOCTOR_HOSPITAL", nullable = false)
    private int doctorHospital;

    @Column(name = "DOCTOR_DEPARTMENT", nullable = false)
    private int doctorDepartment;

    @Column(name = "DOCTOR_SPECIALTY", nullable = false)
    private int doctorSpecialty;

    @Lob
    @Column(name = "DOCTOR_E_SIGNATURE")
    private byte[] doctorESignature;

    @Column(name = "DOCTOR_LICENSE_NUMBER", nullable = false)
    private String doctorLicenseNumber;

    @Column(name = "DOCTOR_LICENSE_EXP_DATE", nullable = false)
    private Date doctorLicenseExpDate;

    @Column(name = "DOCTOR_SCHEDULE", nullable = false)
    private int doctorSchedule;
}
