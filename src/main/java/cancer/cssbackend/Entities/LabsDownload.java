package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "LABSDOWNLOAD")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LabsDownload {
    @Id
    @GeneratedValue(generator = "LABSDOWNLOAD_SEQ")
    @SequenceGenerator(name="LABSDOWNLOAD_SEQ", sequenceName = "LABSDOWNLOAD_SEQ", allocationSize = 1)
    @Column(name = "LABREQ_ID")
    private Long labsDownloadID;

    @Column(name = "LABREQ_DATE")
    private Timestamp labReqDate;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "WORKUP_NAME")
    private Workup workup;
}
