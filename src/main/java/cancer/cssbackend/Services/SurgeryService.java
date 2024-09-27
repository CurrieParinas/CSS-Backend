package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.SurgeryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurgeryService {
    private final SurgeryRepository surgeryRepository;
}
