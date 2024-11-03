package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "SYMPTOMCATEGORY")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SymptomCategory {
    @Id
    @SequenceGenerator(name = "SYMPTOMCATEGORY_SEQ", sequenceName = "SYMPTOMCATEGORY_SEQ", allocationSize = 1)
    @Column(name = "SYMPTOMCATEGORY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SYMPTOMCATEGORY_SEQ")
    private Long symptomCategoryID;

    @Column(name = "SYMPTOM_CATEGORY")
    private String symptomCategory;
}
