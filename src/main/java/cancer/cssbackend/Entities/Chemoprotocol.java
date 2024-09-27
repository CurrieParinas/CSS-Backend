package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "CHEMOPROTOCOL")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Chemoprotocol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CHEMOPROTOCOL_SEQ")
    @SequenceGenerator(name = "CHEMOPROTOCOL_SEQ", sequenceName = "CHEMOPROTOCOL_SEQ", allocationSize = 1)
    @Column(name = "CHEMOPROTOCOL_ID", nullable = false)
    private Long chemoProtocolId;

    @Column(name = "CHEMODRUGS", nullable = false)
    private String chemoDrugs;

    @Column(name = "CHEMODOSAGE", nullable = false)
    private Long chemoDosage;

    @Column(name = "CHEMONOCYCLE", nullable = false)
    private Long chemoNoCycle;

    @Column(name = "CHEMODILUENT", nullable = false)
    private String chemoDiluent;
}
