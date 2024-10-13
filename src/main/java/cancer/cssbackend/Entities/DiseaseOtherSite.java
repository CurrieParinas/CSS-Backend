package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "DISEASEOTHERSITE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DiseaseOtherSite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "DISEASEOTHERSITE_SEQ")
    @SequenceGenerator(name = "DISEASEOTHERSITE_SEQ", sequenceName = "DISEASEOTHERSITE_SEQ", allocationSize = 1)
    @Column(name = "DISEASEOTHERSITE_ID", nullable = false)
    private Long diseaseothersiteId;

    @ManyToOne
    @JoinColumn(name = "DISEASE_ID", referencedColumnName = "DISEASE_ID")
    private Disease disease;

    @ManyToOne
    @JoinColumn(name = "BODYSITE_ID", referencedColumnName = "BODYSITE_ID")
    private BodySite bodySite;
}
