package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "BASIS")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Basis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "BASIS_SEQ")
    @SequenceGenerator(name = "BASIS_SEQ", sequenceName = "BASIS_SEQ", allocationSize = 1)
    @Column(name = "BASIS_ID", nullable = false)
    private Long basisId;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "SUBCATEGORY")
    private String subcategory;
}
