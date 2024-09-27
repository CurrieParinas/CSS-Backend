package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.print.Doc;

@Entity(name = "ONBOARD")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Onboard {
    @Id
    @SequenceGenerator(name = "ONBOARD_SEQ", sequenceName = "ONBOARD_SEQ", allocationSize = 1)
    @Column(name = "RELATION_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ONBOARD_SEQ")
    private Long relationId;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID", referencedColumnName = "DOCTOR_ID")
    private Doctor doctor;

    @Column(name = "DOCTOR_ROLE")
    private String doctorRole;
}
