package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.WorkupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkupService {
    private final WorkupRepository workupRepository;
}
