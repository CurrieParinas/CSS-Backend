package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "BODYSITE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BodySite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "BODYSITE_SEQ")
    @SequenceGenerator(name = "BODYSITE_SEQ", sequenceName = "BODYSITE_SEQ", allocationSize = 1)
    @Column(name = "BODYSITE_ID", nullable = false)
    private Long bodysiteId;

    @Column(name = "BODYSITE_NAME")
    private String bodysiteName;
}
