package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.DiseaseOtherSite;
import cancer.cssbackend.Repositories.DiseaseOtherSiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiseaseOtherSiteService {
    private final DiseaseOtherSiteRepository diseaseOtherSiteRepository;

    public List<DiseaseOtherSite> fetchByDiseaseID(Long diseaseID){
        return diseaseOtherSiteRepository.fetchOtherSitesByDiseaseID(diseaseID);
    }
}
