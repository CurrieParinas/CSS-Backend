package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;

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

    @OneToOne
    @JoinColumn(name = "LAB_SUBMITTED_ID")
    private LabSubmitted labSubmitted;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "EMAIL_STATUS")
    private String emailStatus;
}
