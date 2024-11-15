package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "NOTIFICATIONSTATUS")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class NotificationStatus {
    @Id
    @SequenceGenerator(name = "NOTIFICATIONSTATUS_SEQ", sequenceName = "NOTIFICATIONSTATUS_SEQ", allocationSize = 1)
    @Column(name = "NOTIFSTATUS_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "NOTIFICATIONSTATUS_SEQ")
    private Long notifStatusID;


    @Column(name="NOTIFSTATUS_NAME", nullable = false, length = 200)
    private String notifStatusName;
}
