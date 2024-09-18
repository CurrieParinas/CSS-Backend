package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.BodySiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BodySiteService {
    private final BodySiteRepository bodySiteRepository;
}
