package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.ChemoprotocolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemoprotocolService {
    private final ChemoprotocolRepository chemoprotocolRepository;
}
