package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "NOTIFICATIONTYPE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class NotificationType {
    @Id
    @SequenceGenerator(name = "NOTIFICATIONTYPE_SEQ", sequenceName = "NOTIFICATIONTYPE_SEQ", allocationSize = 1)
    @Column(name = "NOTIFTYPE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "NOTIFICATIONTYPE_SEQ")
    private Long notifTypeId;

    @Column(name="NOTIFICATIONTYPE_NAME", nullable = false, length = 200)
    private String notificationTypeName;
}
