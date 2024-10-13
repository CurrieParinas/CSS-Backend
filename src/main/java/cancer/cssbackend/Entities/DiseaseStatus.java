package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "DISEASESTATUS")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DiseaseStatus {
    @Id
    @SequenceGenerator(name = "DISEASESTATUS_SEQ", sequenceName = "DISEASESTATUS_SEQ", allocationSize = 1)
    @Column(name = "DXSTATUS_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "DISEASESTATUS_SEQ")
    private Long dxstatusId;

    @OneToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID")
    private Patient patient;

    @Column(name = "DXSTATUS_ALIVE")
    private char dxstatusAlive;

    @Column(name = "DXSTATUS_SYMPTOMS")
    private char dxstatusSymptoms;

    @Column(name = "DXSTATUS_RECURRENCE")
    private char dxstatusRecurrence;

    @Column(name = "DXSTATUS_METASTATIC")
    private char dxstatusMetastatic;

    @Column(name = "DXSTATUS_CURATIVE")
    private char dxstatusCurative;

    @Column(name = "DXSTATUS_CREATED_ON")
    private Timestamp dxstatusCreatedOn;
}
