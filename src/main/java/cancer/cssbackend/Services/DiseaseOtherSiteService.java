package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.DiseaseOtherSiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiseaseOtherSiteService {
    private final DiseaseOtherSiteRepository diseaseOtherSiteRepository;
}
