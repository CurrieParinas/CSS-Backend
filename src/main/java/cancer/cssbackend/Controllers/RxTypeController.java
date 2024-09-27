package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.RxTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/rxtype")
public class RxTypeController {
    private final RxTypeService rxTypeService;
}
