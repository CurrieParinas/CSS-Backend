package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.HistologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/histology"})
public class HistologyController {
    private final HistologyService histologyService;
}
