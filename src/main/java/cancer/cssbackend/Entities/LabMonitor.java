package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "LABMONITOR")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LabMonitor {
    @Id
    @GeneratedValue(generator = "LABMONITOR_SEQ")
    @SequenceGenerator(name="LABMONITOR_SEQ", sequenceName = "LABMONITOR_SEQ", allocationSize = 1)
    @Column(name = "LABMONITOR_ID")
    private Long labMonitorID;

    @ManyToOne
    @JoinColumn(name = "CANCER_TYPE")
    private BodySite cancerType;

    @ManyToOne
    @JoinColumn(name = "WORKUP_NAME")
    private Workup workup;

    @Column(name = "WORKUP_FREQUENCY")
    private Integer workupFrequency;

    @Column(name = "WORKUP_TYPE")
    private Long workupType;

    @Column(name = "WORKUP_INDICATION")
    private String workupIndication;

    @Column(name = "WORKUP_DURATION")
    private Integer workupDuration;

    @Column(name = "WORKUP_REFERRAL")
    private String workupReferral;
}
