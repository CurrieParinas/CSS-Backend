package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.ChemotherapyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemotherapyService {
    private final ChemotherapyRepository chemotherapyRepository;
}
