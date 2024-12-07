package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Requests.AddSurveyResponseRequest;
import cancer.cssbackend.Entities.Surgery;
import cancer.cssbackend.Entities.SurveyResponse;
import cancer.cssbackend.Repositories.DoctorRepository;
import cancer.cssbackend.Repositories.PatientRepository;
import cancer.cssbackend.Repositories.SurveyResponseRepository;
import cancer.cssbackend.Repositories.SymptomSurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyResponseService {
    private final SurveyResponseRepository surveyResponseRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final SymptomSurveyRepository symptomSurveyRepository;

    public SurveyResponse addSurveyResponse(AddSurveyResponseRequest addSurveyResponseRequest){
        SurveyResponse surveyResponse = addSurveyResponseRequest.mapToSurveyResponse(patientRepository, doctorRepository, symptomSurveyRepository);
        surveyResponseRepository.save(surveyResponse);
        return surveyResponse;
    }

    public SurveyResponse fetchExistingSurveyResponse(Long patientID, Long doctorID){
        return surveyResponseRepository.fetchExistingSurveyResponse(patientID, doctorID);
    }
}
