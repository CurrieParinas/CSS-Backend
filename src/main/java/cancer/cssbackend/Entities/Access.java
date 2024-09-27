package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "ACCESSTABLE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Access {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ACCESS_SEQ")
    @SequenceGenerator(name = "ACCESS_SEQ", sequenceName = "ACCESS_SEQ", allocationSize = 1)
    @Column(name = "ACCESS_ID", nullable = false)
    private Long accessId;

    @Column(name = "ACCESS_CANENROLLPATIENT")
    private char accessCanenrollpatient;

    @Column(name = "ACCESS_CANEDITPATIENTINFO")
    private char accessCaneditpatientinfo;

    @Column(name = "ACCESS_CANVIEWPATIENTINFO")
    private char accessCanviewpatientinfo;

    @Column(name = "ACCESS_CANDELETEUSER")
    private char accessCandeleteuser;

    @Column(name = "ACCESS_CANDELETEPATIENTINFO")
    private char accessCandeletepatientinfo;
}
