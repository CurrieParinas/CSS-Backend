package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.RxTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RxTypeService {
    private final RxTypeRepository rxTypeRepository;
}
