package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Projections.SymptomProjection;
import cancer.cssbackend.Repositories.SymptomSurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SymptomSurveyService {
    private final SymptomSurveyRepository symptomSurveyRepository;

    public List<SymptomProjection> getSNbyCTLS(Long cancerType){
        return symptomSurveyRepository.fetchSymptomNameByCancerTypeLOCALSYMPTOM(cancerType);
    }

    public List<SymptomProjection> getSNbyCTSS(Long cancerType){
        return symptomSurveyRepository.fetchSymptomNameByCancerTypeSYSTEMICSYMPTOM(cancerType);
    }

    public List<SymptomProjection> getSNbyCTQOL(Long cancerType){
        return symptomSurveyRepository.fetchSymptomNameByCancerTypeQOL(cancerType);
    }

    public List<SymptomProjection> getSNbyCTTSE(Long cancerType){
        return symptomSurveyRepository.fetchSymptomNameByCancerTypeTSE(cancerType);
    }
}
