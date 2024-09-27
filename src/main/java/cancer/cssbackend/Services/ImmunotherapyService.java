package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.ImmunotherapyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImmunotherapyService {
    private final ImmunotherapyRepository immunotherapyRepository;
}
