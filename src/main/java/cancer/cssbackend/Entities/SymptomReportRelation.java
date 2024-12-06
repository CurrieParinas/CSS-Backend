package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@Entity(name = "SYMPTOM_REPORT_RELATION_TABLE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SymptomReportRelation {
    @Id
    @SequenceGenerator(name = "SYMPTOM_REPORT_RELATION_TABLE_SEQ", sequenceName = "SYMPTOM_REPORT_RELATION_TABLE_SEQ", allocationSize = 1)
    @Column(name = "RELATION_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SYMPTOM_REPORT_RELATION_TABLE_SEQ")
    private Long relationId;

    @ManyToOne
    @JoinColumn(name = "SYMPTOMSURVEY_ID", referencedColumnName = "SYMPTOMSURVEY_ID", nullable = false)
    private SymptomSurvey symptomSurvey;

    @ManyToOne
    @JoinColumn(name = "SURVEYRESPONSE_ID", referencedColumnName = "SURVEYRESPONSE_ID", nullable = false)
    private SurveyResponse surveyResponse;

    @Column(name = "CREATED_AT", nullable = false)
    private Timestamp createdAt;

    @Column(name = "UPDATED_AT")
    private Timestamp updatedAt;
}
