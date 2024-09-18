package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.BasisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasisService {
    private final BasisRepository basisRepository;
}
