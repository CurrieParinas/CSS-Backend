package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.print.Doc;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "NOTIFICATIONLOG")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class NotificationLog {
    @Id
    @SequenceGenerator(name = "NOTIFICATIONLOG_SEQ", sequenceName = "NOTIFICATIONLOG_SEQ", allocationSize = 1)
    @Column(name = "NOTIFLOG_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "NOTIFICATIONLOG_SEQ")
    private Long notifLogID;

    @Column(name = "NOTIFICATION_DATE")
    private Date notificationDate;

    @ManyToOne
    @JoinColumn(name = "NOTIFICATION_TYPE", referencedColumnName = "NOTIFTYPE_ID")
    private NotificationType notificationType;

    @ManyToOne
    @JoinColumn(name = "NOTIFICATION_STATUS", referencedColumnName = "NOTIFSTATUS_ID")
    private NotificationStatus notificationStatus;

    @OneToOne
    @JoinColumn(name = "NOTIFICATION_RECEIVER", referencedColumnName = "USER_ID")
    private User notificationReceiver;

    @OneToOne
    @JoinColumn(name = "NOTIFICATION_SENDER", referencedColumnName = "USER_ID")
    private User notificationSender;

    @Column(name = "NOTIFICATION_NOTES", length = 2000)
    private String notificationNotes;

    @Column(name = "NOTIFICATION_UPDATEDON")
    private Timestamp notificationUpdatedOn;
}
