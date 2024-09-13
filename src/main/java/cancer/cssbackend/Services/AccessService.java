package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.AccessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccessService {
    private final AccessRepository accessRepository;
}
