package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.RXType;
import cancer.cssbackend.Repositories.RxTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RxTypeService {
    private final RxTypeRepository rxTypeRepository;

    public RXType findRXType(Long rxTypeID){
        Optional<RXType> rxType = rxTypeRepository.findById(rxTypeID);
        return rxType.orElseThrow(() -> new RuntimeException("RXType not found with ID " + rxType));
    }
}
