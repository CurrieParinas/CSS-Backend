package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "CHECKUPSCHEDULE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CheckupSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CHECKUPSCHEDULE_SEQ")
    @SequenceGenerator(name = "CHECKUPSCHEDULE_SEQ", sequenceName = "CHECKUPSCHEDULE_SEQ", allocationSize = 1)
    @Column(name = "CHECKUPSCHED_ID", nullable = false)
    private Long checkupScheduleID;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor doctor;

    @Column(name = "CHECKUPREQUEST_DATE")
    private Date checkupRequestDate;

    @Column(name = "CHECKUPCONFIRMED_DATE")
    private Date checkupConfirmedDate;

    @Column(name = "CHECKUP_STARTTIME")
    private Timestamp checkupStartTime;

    @Column(name = "CHECKUP_ENDTIME")
    private Timestamp checkupEndTime;

    @ManyToOne
    @JoinColumn(name = "CHECKUP_STATUS")
    private CheckupStatus checkupStatus;

    @Column(name = "CHECKUP_UPDATEDON")
    private Timestamp checkupUpdatedOn;
}
