package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.RXType;
import cancer.cssbackend.Entities.Requests.AddRxTypeRequest;
import cancer.cssbackend.Repositories.RxTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RxTypeService {
    private final RxTypeRepository rxTypeRepository;
    private final UserService userService;
    private final PatientService patientService;

    public RXType findRXType(Long rxTypeID) {
        return rxTypeRepository.findById(rxTypeID)
                .orElse(null);
    }

    public RXType addRXType(AddRxTypeRequest addRxTypeRequest){
        RXType rxType = addRxTypeRequest.mapToRxType(userService, patientService);
        rxTypeRepository.save(rxType);
        return rxType;
    }
}
