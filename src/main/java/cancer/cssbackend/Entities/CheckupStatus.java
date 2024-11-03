package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "CHECKUPSTATUS")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CheckupStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CHECKUPSTATUS_SEQ")
    @SequenceGenerator(name = "CHECKUPSTATUS_SEQ", sequenceName = "CHECKUPSTATUS_SEQ", allocationSize = 1)
    @Column(name = "CHECKUPSTATUS_ID", nullable = false)
    private Long checkupStatusID;

    @Column(name = "NOTIFSTATUS_NAME", nullable = false, length = 100)
    private String notifStatusName;
}
