package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.RadDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RadDetailsService {
    private final RadDetailsRepository radDetailsRepository;
}
