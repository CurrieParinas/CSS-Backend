package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.HormonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HormonalService {
    private final HormonalRepository hormonalRepository;
}
