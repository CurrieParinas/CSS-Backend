package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "RAD_DETAILS")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RadDetails {
    @Id
    @GeneratedValue(generator = "RAD_DETAILS_SEQ")
    @SequenceGenerator(name="RAD_DETAILS_SEQ", sequenceName = "RAD_DETAILS_SEQ", allocationSize = 1)
    @Column(name = "RADDETAILS_ID", nullable = false)
    private Long radDetailsId;

    @Column(name = "RADDETAILS_PROCEDURE", nullable = false, length = 255)
    private String radDetailsProcedure;
}
