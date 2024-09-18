package cancer.cssbackend.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("BODYSITE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "BODYSITE_SEQ")
    @SequenceGenerator(name = "BODYSITE_SEQ", sequenceName = "BODYSITE_SEQ", allocationSize = 1)
    @Column(name = "BODYSITE_ID", nullable = false)
    private Long bodySiteID;

    @Column(name = "BODYSITE_NAME")
    private String bodySiteName;
}
