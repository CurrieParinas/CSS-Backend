package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.RadDetails;
import cancer.cssbackend.Repositories.RadDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RadDetailsService {
    private final RadDetailsRepository radDetailsRepository;

    public RadDetails findRadDetails(Long radDetailsID){
        Optional<RadDetails> radDetails = radDetailsRepository.findById(radDetailsID);
        return radDetails.orElseThrow(() -> new RuntimeException("RadDetails not found with ID " + radDetailsID));
    }
}
