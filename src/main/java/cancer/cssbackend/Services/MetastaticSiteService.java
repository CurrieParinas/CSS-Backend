package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.MetastaticSiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetastaticSiteService {
    private final MetastaticSiteRepository metastaticSiteRepository;
}
