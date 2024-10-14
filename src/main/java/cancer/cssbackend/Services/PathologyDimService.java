package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.PathologyDim;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Repositories.PathologyDimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PathologyDimService {
    private final PathologyDimRepository pathologyDimRepository;

    public PathologyDim findPathology(Long pathologyDimID){
        Optional<PathologyDim> pathologyDim = pathologyDimRepository.findById(pathologyDimID);
        return pathologyDim.orElseThrow(() -> new RuntimeException("Pathology not found with ID " + pathologyDim));
    }

    public List<PathologyDim> fetchAllPathologyDim(){
        return pathologyDimRepository.findAll();
    }
}
