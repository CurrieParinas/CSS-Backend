package cancer.cssbackend.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("ACCESS_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ACCESS_SEQ")
    @SequenceGenerator(name = "ACCESS_SEQ", sequenceName = "ACCESS_SEQ", allocationSize = 1)
    @Column(name = "ACCESS_ID", nullable = false)
    private Long accessID;

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
