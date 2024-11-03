package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "WORKUP")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Workup {
    @Id
    @GeneratedValue(generator = "WORKUP_SEQ")
    @SequenceGenerator(name = "WORKUP_SEQ", sequenceName = "WORKUP_SEQ", allocationSize = 1)
    @Column(name = "WORKUP_ID")
    private Long workupID;

    @Column(name = "WORKUP_NAME")
    private String workupName;

}
