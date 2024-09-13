package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.OnboardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OnboardService {
    private final OnboardRepository onboardRepository;
}
