package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.PathologyDimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PathologyDimService {
    private final PathologyDimRepository pathologyDimRepository;
}
