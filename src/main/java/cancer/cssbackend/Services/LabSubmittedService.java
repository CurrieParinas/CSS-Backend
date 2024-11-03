package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.LabSubmittedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LabSubmittedService {
    private final LabSubmittedRepository labSubmittedRepository;
}
