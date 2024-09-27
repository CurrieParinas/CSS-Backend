package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "ROLE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Role {
    @Id
    @GeneratedValue(generator = "ROLE_SEQ")
    @SequenceGenerator(name="ROLE_SEQ", sequenceName = "ROLE_SEQ", allocationSize = 1)
    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @Column(name = "ROLE_DESCRIPTION")
    private String roleDescription;

}
