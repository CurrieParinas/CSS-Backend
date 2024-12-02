package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.SymptomSurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SymptomSurveyService {
    private final SymptomSurveyRepository symptomSurveyRepository;

    public List<String> getSNbyCTLS(Long cancerType){
        return symptomSurveyRepository.fetchSymptomNameByCancerTypeLOCALSYMPTOM(cancerType);
    }

    public List<String> getSNbyCTSS(Long cancerType){
        return symptomSurveyRepository.fetchSymptomNameByCancerTypeSYSTEMICSYMPTOM(cancerType);
    }

    public List<String> getSNbyCTQOL(Long cancerType){
        return symptomSurveyRepository.fetchSymptomNameByCancerTypeQOL(cancerType);
    }

    public List<String> getSNbyCTTSE(Long cancerType){
        return symptomSurveyRepository.fetchSymptomNameByCancerTypeTSE(cancerType);
    }
}
