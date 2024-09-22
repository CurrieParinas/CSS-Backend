package cancer.cssbackend.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("PATIENT_ID")
    @GeneratedValue(generator = "PATIENT_SEQ")
    @SequenceGenerator(name="PATIENT_SEQ", sequenceName = "PATIENT_SEQ", allocationSize = 1)
    @Column(name = "PATIENT_ID")
    private Long patientId;

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @JsonProperty("USER")
    private User user;

    @JsonProperty("PATIENT_CREATED_ON")
    private Timestamp patientCreatedOn;

    @JsonProperty("PATIENT_UPDATED_ON")
    private Timestamp patientUpdatedOn;
}
