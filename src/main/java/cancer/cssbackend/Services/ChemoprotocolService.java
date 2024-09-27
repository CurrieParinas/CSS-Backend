package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.Chemoprotocol;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Repositories.ChemoprotocolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChemoprotocolService {
    private final ChemoprotocolRepository chemoprotocolRepository;

    public Chemoprotocol findChemoprotocol(Long chemoprotocolID){
        Optional<Chemoprotocol> chemoprotocol = chemoprotocolRepository.findById(chemoprotocolID);
        return chemoprotocol.orElseThrow(() -> new RuntimeException("Chemoprotocol not found with ID " + chemoprotocolID));
    }
}
