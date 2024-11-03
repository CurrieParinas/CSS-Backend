package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.LabMonitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LabMonitorService {
    private final LabMonitorRepository labMonitorRepository;
}
