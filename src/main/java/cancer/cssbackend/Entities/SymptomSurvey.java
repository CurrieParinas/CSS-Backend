package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "SYMPTOMSURVEY")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SymptomSurvey {
    @Id
    @SequenceGenerator(name = "SYMPTOMSURVEY_SEQ", sequenceName = "SYMPTOMSURVEY_SEQ", allocationSize = 1)
    @Column(name = "SYMPTOMSURVEY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SYMPTOMSURVEY_SEQ")
    private Long symptomSurveyID;

    @ManyToOne
    @JoinColumn(name = "CANCER_TYPE", referencedColumnName = "BODYSITE_ID")
    private BodySite cancerType;

    @Column(name = "SYMPTOM_NAME", nullable = false, length = 200)
    private String symptomName;

    @Column(name = "SYMPTOM_MEDICALTERM", length = 200)
    private String symptomMedicalTerm;

    @ManyToOne
    @JoinColumn(name = "SYMPTOM_CATEGORY", referencedColumnName = "SYMPTOMCATEGORY_ID")
    private SymptomCategory symptomCategory;

    @Column(name = "SYMPTOM_FILIPINO", length = 100)
    private String symptomFilipino;

    @Column(name = "SYMPTOM_ALERTABLE")
    private String symptomAlertable;
}
