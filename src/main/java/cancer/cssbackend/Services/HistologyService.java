package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.HistologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistologyService {
    private final HistologyRepository histologyRepository;
}
