package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.DiseaseStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiseaseStatusService {
    private final DiseaseStatusRepository diseaseStatusRepository;
}
