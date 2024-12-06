package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Requests.AddSymptomReportRelationRequest;
import cancer.cssbackend.Entities.SymptomReportRelation;
import cancer.cssbackend.Repositories.SurveyResponseRepository;
import cancer.cssbackend.Repositories.SymptomReportRelationRepository;
import cancer.cssbackend.Repositories.SymptomSurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SymptomReportRelationService {
    private final SymptomReportRelationRepository symptomReportRelationRepository;
    private final SymptomSurveyRepository symptomSurveyRepository;
    private final SurveyResponseRepository surveyResponseRepository;

    public SymptomReportRelation addSymptomReportRelation(AddSymptomReportRelationRequest addSymptomReportRelationRequest){
        SymptomReportRelation symptomReportRelation = addSymptomReportRelationRequest.mapToSymptomReportRelation(symptomSurveyRepository, surveyResponseRepository);
        symptomReportRelationRepository.save(symptomReportRelation);

        return symptomReportRelation;
    }
}
