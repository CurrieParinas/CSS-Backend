package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.SymptomCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/symptom/category")
public class SymptomCategoryController {
    private final SymptomCategoryService symptomCategoryService;
}
