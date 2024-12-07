package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "SURVEYRESPONSE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SurveyResponse {
    @Id
    @SequenceGenerator(name = "SURVEYRESPONSE_SEQ", sequenceName = "SURVEYRESPONSE_SEQ", allocationSize = 1)
    @Column(name = "SURVEYRESPONSE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SURVEYRESPONSE_SEQ")
    private Long surveyResponseID;

    @OneToOne
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor doctor;

    @Column(name = "SURVEYRESPONSE_DATE")
    private Timestamp surveyResponseDate;

    @Column(name = "RESPONSE_NOTE")
    private String responseNote;
}
