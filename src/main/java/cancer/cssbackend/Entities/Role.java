package cancer.cssbackend.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("ROLE_ID")
    @GeneratedValue(generator = "ROLE_SEQ")
    @SequenceGenerator(name="ROLE_SEQ", sequenceName = "ROLE_SEQ", allocationSize = 1)
    @Column(name = "ROLE_ID")
    private Long roleId;
    @JsonProperty("ROLE_NAME")
    private String roleName;
    @JsonProperty("ROLE_DESCRIPTION")
    private String roleDescription;

}
