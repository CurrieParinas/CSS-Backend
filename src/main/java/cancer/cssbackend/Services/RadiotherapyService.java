package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.RadiotherapyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RadiotherapyService {
    private final RadiotherapyRepository radiotherapyRepository;
}
