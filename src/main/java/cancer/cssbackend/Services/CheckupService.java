package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.CheckupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckupService {
    private final CheckupRepository checkupRepository;
}
