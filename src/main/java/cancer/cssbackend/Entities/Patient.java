package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "PATIENT")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Patient {
    @Id
    @GeneratedValue(generator = "PATIENT_SEQ")
    @SequenceGenerator(name="PATIENT_SEQ", sequenceName = "PATIENT_SEQ", allocationSize = 1)
    @Column(name = "PATIENT_ID")
    private Long patientId;

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;

    @Column(name = "PATIENT_CREATED_ON")
    private Timestamp patientCreatedOn;

    @Column(name = "PATIENT_UPDATED_ON")
    private Timestamp patientUpdatedOn;
}
