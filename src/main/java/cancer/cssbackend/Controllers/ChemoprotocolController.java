package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.ChemoprotocolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/chemoprotocol")
public class ChemoprotocolController {
    private final ChemoprotocolService chemoprotocolService;
}
