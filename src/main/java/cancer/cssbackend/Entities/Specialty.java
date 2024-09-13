package cancer.cssbackend.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "SPECIALTY")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Specialty {
    @Id
    @SequenceGenerator(name = "SPECIALTY_SEQ", sequenceName = "SPECIALTY_SEQ", allocationSize = 1)
    @Column(name = "SPECIALTY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SPECIALTY_SEQ")
    private Long specialtyID;

    @Column(name = "SPECIALTY_NAME")
    private String specialtyName;

    @Column(name = "SPECIALTY_DESCRIPTION")
    private String specialtyDescription;
}
