package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;

@Entity(name = "LABSUBMITTED")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LabSubmitted {
    @Id
    @GeneratedValue(generator = "LABSUBMITTED_SEQ")
    @SequenceGenerator(name="LABSUBMITTED_SEQ", sequenceName = "LABSUBMITTED_SEQ", allocationSize = 1)
    @Column(name = "LABSUBMITTED_ID")
    private Long labSubmittedID;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor doctor;

    @Column(name = "LABSUBMISSION_DATE")
    private Timestamp labSubmissionDate;

    @ManyToOne
    @JoinColumn(name = "WORKUP_NAME")
    private Workup workupName;

    @Column(name = "LABFILELOCATION", nullable = false)
    private byte[] labFileLocation;

    @Column(name = "LABSUBMISSION_NOTES")
    private String labSubmissionNotes;
}
