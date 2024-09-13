package cancer.cssbackend.Controllers;

import cancer.cssbackend.Services.AccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/address")
public class AccessController {
    private final AccessService accessService;
}
