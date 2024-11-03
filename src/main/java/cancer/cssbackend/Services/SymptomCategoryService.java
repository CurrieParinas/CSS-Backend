package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.SymptomCategory;
import cancer.cssbackend.Repositories.SymptomCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SymptomCategoryService {
    private final SymptomCategoryRepository symptomCategoryRepository;
}
