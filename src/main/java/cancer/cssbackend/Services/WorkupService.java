package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Projections.WorkupProjection;
import cancer.cssbackend.Entities.Workup;
import cancer.cssbackend.Repositories.WorkupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkupService {
    private final WorkupRepository workupRepository;

    public List<WorkupProjection> getWorkupProjections(Long cancerType){
        return workupRepository.getWorkupProjection(cancerType);
    }

    public List<Workup> getAllWorkup(){
        return workupRepository.findAll();
    }
}
