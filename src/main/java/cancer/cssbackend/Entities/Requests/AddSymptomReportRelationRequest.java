package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.SurveyResponse;
import cancer.cssbackend.Entities.SymptomReportRelation;
import cancer.cssbackend.Entities.SymptomSurvey;
import cancer.cssbackend.Repositories.SurveyResponseRepository;
import cancer.cssbackend.Repositories.SymptomSurveyRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

public class AddSymptomReportRelationRequest {
    @JsonProperty("symptomSurveyId")
    private Long symptomSurveyId;

    @JsonProperty("surveyResponseId")
    private Long surveyResponseId;

    public SymptomReportRelation mapToSymptomReportRelation(SymptomSurveyRepository symptomSurveyRepository, SurveyResponseRepository surveyResponseRepository) {
        SymptomReportRelation symptomReportRelation = new SymptomReportRelation();

        Optional<SymptomSurvey> symptomSurvey = symptomSurveyRepository.findById(this.symptomSurveyId);
        if(symptomSurvey.isPresent()){
            symptomReportRelation.setSymptomSurvey(symptomSurvey.get());
        } else{
            throw new RuntimeException("No Symptom found with ID: " + symptomSurveyId);
        }

        Optional<SurveyResponse> surveyResponse = surveyResponseRepository.findById(this.surveyResponseId);
        if(surveyResponse.isPresent()){
            symptomReportRelation.setSurveyResponse(surveyResponse.get());
        } else {
            throw new RuntimeException("No Survey Response found with ID: " + surveyResponseId);
        }

        symptomReportRelation.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        return symptomReportRelation;
    }
}
