package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.SymptomSurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SymptomSurveyService {
    private final SymptomSurveyRepository symptomSurveyRepository;
}
