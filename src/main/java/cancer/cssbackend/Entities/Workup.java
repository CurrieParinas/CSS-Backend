package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "WORKUP")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Workup {
    @Id
    @GeneratedValue(generator = "WORKUP_SEQ")
    @SequenceGenerator(name = "WORKUP_SEQ", sequenceName = "WORKUP_SEQ", allocationSize = 1)
    @Column(name = "WORKUP_ID")
    private Long workupID;

    @ManyToOne
    @JoinColumn(name = "CANCER_TYPE")
    private BodySite cancerType;

    @Column(name = "WORKUP_NAME")
    private String workupName;

    @Column(name = "WORKUP_FREQUENCY")
    private Integer workupFrequency;

    @Column(name = "WORKUP_TYPE")
    private String workupType;

    @Column(name = "WORKUP_INDICATION")
    private String workupIndication;

    @Column(name = "WORKUP_DURATION")
    private Integer workupDuration;

    @Column(name = "WORKUP_REFERRAL")
    private String workupReferral;
}
