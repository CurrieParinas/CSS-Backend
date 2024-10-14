package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "PATHOLOGY_DIM")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PathologyDim {
    @Id
    @GeneratedValue(generator = "PATHOLOGY_DIM_SEQ")
    @SequenceGenerator(name="PATHOLOGY_DIM_SEQ", sequenceName = "PATHOLOGY_DIM_SEQ", allocationSize = 1)
    @Column(name = "PATHOLOGY_DIM_ID")
    private Long pathologyDimId;

    @Column(name = "ICDO32")
    private String icdo32;

    @Column(name = "PATHOLOGY_DIM_LEVEL")
    private String pathologyDimLevel;

    @Column(name = "TERM", length = 1000)
    private String term;

    @Column(name = "CODE_REFERENCE")
    private String codeReference;

    @Column(name = "OBS", length = 10)
    private String obs;

    @Column(name = "SEE_ALSO")
    private String seeAlso;

    @Column(name = "SEE_NOTE", length = 1000)
    private String seeNote;

    @Column(name = "INCLUDES", length = 1000)
    private String includes;

    @Column(name = "EXCLUDES", length = 1000)
    private String excludes;

    @Column(name = "OTHER_TEXT", length = 1000)
    private String otherText;
}
