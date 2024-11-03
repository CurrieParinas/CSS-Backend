package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.SurveyResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyResponseService {
    private final SurveyResponseRepository surveyResponseRepository;
}
