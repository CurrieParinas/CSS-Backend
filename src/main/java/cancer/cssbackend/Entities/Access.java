package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "ADDRESS")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Access {
    @Id
    @SequenceGenerator(name = "ACCESS_SEQ", sequenceName = "ACCESS_SEQ", allocationSize = 1)
    @Column(name = "ACCESS_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ACCESS_SEQ")
    private Long accessID;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @Column(name = "USER_ID")
    private User user;

    @Column(name = "ACCESS_CANENROLLPATIENT")
    private char accessCanEnrollPatient;

    @Column(name = "ACCESS_CANEDITPATIENTINFO")
    private char accessCanEditPatientInfo;

    @Column(name = "ACCESS_CANVIEWPATIENTINFO")
    private char accessCanViewPatientInfo;

    @Column(name = "ACCESS_CANDELETEUSER")
    private char accessCanDeleteUser;

    @Column(name = "ACCESS_CANDELETEPATIENTINFO")
    private char accessCanDeletePatientInfo;
}
