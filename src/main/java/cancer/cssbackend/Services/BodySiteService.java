package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.BodySite;
import cancer.cssbackend.Repositories.BodySiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BodySiteService {
    private final BodySiteRepository bodySiteRepository;

    public List<BodySite> fetchAllBodySite(){
        return bodySiteRepository.findAll();
    }
}
